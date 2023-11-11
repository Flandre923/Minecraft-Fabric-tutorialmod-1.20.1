package net.flandre923.tutorialmod.block.custom;

import net.flandre923.tutorialmod.block.entity.ModBlockEntities;
import net.flandre923.tutorialmod.block.entity.TerraCondensationEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TerraCondensationCube extends BlockWithEntity implements BlockEntityProvider {
    public TerraCondensationCube(Settings settings) {
        super(settings);
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    // 当在方块上丢了红石 + 铁 + 珍珠时候，并且方块被木棍右键的时候就20tick后将泥土变为钻石 并有粒子特效
    // 需要判断是否组成了多方块结构
    // 多方块结构是
    // 当前方块下面是
    // *#*
    // #*#
    // *#*
    // * 金方块
    // # 钻石方块
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TerraCondensationEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.TERRA_CONDENSATION, TerraCondensationEntity::tick);
    }
}
