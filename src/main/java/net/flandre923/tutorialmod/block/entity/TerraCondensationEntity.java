package net.flandre923.tutorialmod.block.entity;

import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class TerraCondensationEntity extends BlockEntity {
    public int maxProgress = 10;
    public int progress = 0;
    public int timer = 0;

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
        List<ItemEntity> list = entity.getItems(world);
        // 如果不符合合成列表返回
        if(!list.isEmpty()){
            TutorialMod.LOGGER.info(list.toString());
        }

        // 进度条 ++

        // 当进度条满了就消除物品 并返回合成物品

    }

    // 判断结构是否完成

    // 判断是否符合合成列表
    // 获得当前方块上的掉落实体


    public List<ItemEntity> getItems(World world) {
        return world.getEntitiesByClass(ItemEntity.class, new Box(pos,pos.add(1,1,1)).expand(1), entity -> true);
    }


    // 返回合成物品



}
