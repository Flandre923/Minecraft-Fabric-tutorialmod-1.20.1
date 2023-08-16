package net.flandre923.tutorialmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.block.custom.ExampleAnimationBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {

    public static BlockEntityType<GemInfusingBlockEntity> GEM_INFUSING_STATION;
    public static BlockEntityType<ExampleAnimationBlockEntity> EXAMPLE_ANIMATION_BLOCK_ENTITY;

    public static void registerBlockEntities(){
        GEM_INFUSING_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TutorialMod.MOD_ID,"gem_infusing_station"),
                FabricBlockEntityTypeBuilder.create(GemInfusingBlockEntity::new,
                        ModBlocks.GEM_INFUSING_STATION).build(null));

        EnergyStorage.SIDED.registerForBlockEntities((blockEntity, context) -> ((GemInfusingBlockEntity)blockEntity).energyStorage,GEM_INFUSING_STATION);
        FluidStorage.SIDED.registerForBlockEntities((blockEntity, context) -> ((GemInfusingBlockEntity)blockEntity).fluidStorage,GEM_INFUSING_STATION);

        EXAMPLE_ANIMATION_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TutorialMod.MOD_ID,"example_animation_block"),
                FabricBlockEntityTypeBuilder.create(ExampleAnimationBlockEntity::new,
                ModBlocks.EXAMPLE_ANIAMTION_BLOCK).build());
    }



}
