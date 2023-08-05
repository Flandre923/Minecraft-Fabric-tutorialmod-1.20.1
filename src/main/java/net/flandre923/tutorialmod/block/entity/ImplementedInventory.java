package net.flandre923.tutorialmod.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * 这是一个简单的 sidedInventory 实现，包含了默认的方法和获得物品的列表的方法。
 *  使用WriteNbt（NbtCompound DefaultedList 和 readNbt（NbtCompoundDefaultList方法
 *  读写 getitems（） 物品列表
 */
@FunctionalInterface
public interface ImplementedInventory extends SidedInventory {
    /**
     * 获得该库存的物品的列表
     * 每次调用返回的必须是相同的实例
     * @return
     */
    DefaultedList<ItemStack> getItems();

    /**
     * 根据物品的列表创建一个inventory
     * @param items 物品列表
     * @return 新的inventory
     */
    static ImplementedInventory of(DefaultedList<ItemStack> items){
        return ()->items;
    }

    /**
     * 更具大小创建一个新的inventory
     * @param size 库存大小
     * @return  新的库存
     */
    static ImplementedInventory offSize(int size){
        return of(DefaultedList.ofSize(size,ItemStack.EMPTY));
    }

    /**
     * 返回指定面的可自动化的可用slot
     * @param side  指定面
     * @return 可用slot
     */
    @Override
     default int[] getAvailableSlots(Direction side){
        int[] result = new int[getItems().size()];
        for(int i = 0;i<result.length;i++){
            result[i] = i;
        }
        return result;
    }

    /**
     * 如果物品可以继续被继续插入到特定的面的特定的slot，则返回true
     * @param slot slot
     * @param stack 物品
     * @param side  指定的面
     * @return 如果可以插入就返回true
     */
    @Override
    default boolean canInsert(int slot, ItemStack stack, @Nullable Direction side){
        return  true;
    }

    /**
     *  如果物品可以从指定的面的指定的slot中提取出来，则返回true
     * @param slot slot
     * @param stack 物品
     * @param dir 面
     * @return 如果可以提取这返回true
     */
    @Override
    default boolean canExtract(int slot, ItemStack stack, Direction dir){
        return true;
    }

    // inventory


    /**
     * 返回invnetory的大小
     *
     * 默认实现返回的是getItems的大小
     * @return inventory的大小
     */
    default int size(){
        return getItems().size();
    }

    /**
     *
     * @return 如果inventory仅包含空的stack则返回true，否则返回false
     */
    @Override
    default boolean isEmpty(){
        for(int i =0;i<size();i++){
            ItemStack stack = getStack(i);
            if(! stack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    /**
     * 获得slot中的物品
     * @param slot slot
     * @return  slot中的物品
     */
    @Override
    default ItemStack getStack(int slot){
        return getItems().get(slot);
    }

    /**
     * 从slot中取出指定数量的物品
     *
     * 如果少于该数量的物品，则全部取出。
     * @param slot slot
     * @param amount 数量
     * @return itemstack
     */
    @Override
    default ItemStack removeStack(int slot, int amount){
        ItemStack result = Inventories.splitStack(getItems(),slot,amount);
        if(!result.isEmpty()){
            markDirty();
        }
        return result;
    }

    /**
     * 移除 slot 中的当前物品stack，并返回itemStack
     * @param slot slot
     * @return 移除的物品stack
     */
    @Override
    default ItemStack removeStack(int slot){
        return Inventories.removeStack(getItems(),slot);
    }

    /**
     *  使用提供的itemStack 替换当前的 ItemStack
     * @param slot slot
     * @param stack 物品stack
     */
    @Override
    default void setStack(int slot, ItemStack stack){
        getItems().set(slot,stack);
        if(stack.getCount() > getMaxCountPerStack()){
            stack.setCount(getMaxCountPerStack());
        }
    }

    /**
     * 清空 inventory
     */
    @Override
    default void clear(){
        getItems().clear();
    }

    /**
     如果想要由行为重写该方法
     */
    @Override
    default void markDirty(){

    }

    @Override
    default boolean canPlayerUse(PlayerEntity entity){
        return true;
    }
}
