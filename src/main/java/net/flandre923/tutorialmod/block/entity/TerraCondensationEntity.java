package net.flandre923.tutorialmod.block.entity;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class TerraCondensationEntity extends BlockEntity {
    public int maxProgress = 10;
    public int progress = 0;
    public int timer = 0;

    // 钻石检测的位置
    private static final BlockPos[] LAPIS_BLOCKS = {
            new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0),
            new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)
    };
    // 金块检测的位置
    private static final BlockPos[] GOLD_BLOCKS = {
            new BlockPos(0, 0, 0), new BlockPos(1, 0, 1),
            new BlockPos(1, 0, -1), new BlockPos(-1, 0, 1),
            new BlockPos(-1, 0, -1)
    };


    public TerraCondensationEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public TerraCondensationEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TERRA_CONDENSATION, pos, state);
    }


    public static void tick(World world, BlockPos pos, BlockState state, TerraCondensationEntity entity){
        if(world.isClient){
            return;
        }

        // 如果结构不完整返回
        if(!entity.hasValidPlatform()){
            entity.progress = 0;
            return;
        }

        List<ItemEntity> items = entity.getItems(world);
        // 如果不符合合成列表返回
        if(!items.isEmpty() && entity.areItemsValid(items)){
            // 进度条 ++
            if(entity.timer % 20 == 0){
                entity.progress++;
                if(entity.progress >= entity.maxProgress){
                    // 当进度条满了就消除物品 并返回合成物品
                    ItemEntity item = items.get(0);
                    for(ItemEntity otherItem : items)
                        if(otherItem != item)
                            otherItem.discard();
                        else item.setStack(new ItemStack(Items.NETHERITE_INGOT, 1));

                    world.updateComparators(pos, world.getBlockState(pos).getBlock());
                    entity.progress = 0;
                }
            }
        }else{
            entity.progress = 0;
        }
        entity.timer ++ ;
    }

    // 判断结构是否完成
    boolean hasValidPlatform() {
        return checkAll(LAPIS_BLOCKS, Blocks.DIAMOND_BLOCK) && checkAll(GOLD_BLOCKS, Blocks.GOLD_BLOCK);
    }
    boolean checkAll(BlockPos[] relPositions, Block block) {
        for (BlockPos position : relPositions) {
            if(!checkPlatform(position.getX(), position.getZ(), block))
                return false;
        }
        return true;
    }

    boolean checkPlatform(int xOff, int zOff, Block block) {
        return world.getBlockState(pos.add(xOff, -1, zOff)).getBlock() == block;
    }
    // 判断是否符合合成列表

    boolean areItemsValid(List<ItemEntity> items) {
        if(items.size() != 3)
            return false;

        ItemStack ingot = ItemStack.EMPTY;
        ItemStack pearl = ItemStack.EMPTY;
        ItemStack diamond = ItemStack.EMPTY;
        for(ItemEntity item : items) {
            ItemStack stack = item.getStack();
            if(stack.getCount() != 1)
                return false;

//            int meta = stack.getDamage();
            if(stack.getItem().equals(Items.IRON_INGOT))
                ingot = stack;
            else if(stack.getItem().equals(Items.DIAMOND))
                diamond = stack;
            else if(stack.getItem().equals(Items.ENDER_PEARL))
                pearl = stack;
            else return false;
        }

        return !ingot.isEmpty() && !pearl.isEmpty() && !diamond.isEmpty();
    }
    // 获得当前方块上的掉落实体
    public List<ItemEntity> getItems(World world) {
        return world.getEntitiesByClass(ItemEntity.class, new Box(pos,pos.add(1,1,1)).expand(1), entity -> true);
    }

}
