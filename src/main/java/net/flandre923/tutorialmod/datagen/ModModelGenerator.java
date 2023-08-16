package net.flandre923.tutorialmod.datagen;

import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.block.custom.EggplantCropBlock;
import net.flandre923.tutorialmod.block.custom.TanzaniteLampBlock;
import net.flandre923.tutorialmod.fluid.ModFluids;
import net.flandre923.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.Identifier;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SIMPLE_BLOCK);
        blockStateModelGenerator.registerLog(ModBlocks.RED_MAPLE_LOG).log(ModBlocks.RED_MAPLE_LOG).wood(ModBlocks.RED_MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_RED_MAPLE_LOG).log(ModBlocks.STRIPPED_RED_MAPLE_LOG).wood(ModBlocks.STRIPPED_RED_MAPLE_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.RED_MAPLE_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BUTTERCUPS,ModBlocks.POTTED_BUTTERCUPS,BlockStateModelGenerator.TintType.NOT_TINTED);

        this.registerLamp(blockStateModelGenerator);
        blockStateModelGenerator.registerCrop(ModBlocks.EGGPLANT_CROP, EggplantCropBlock.AGE,0,1,2,3,4,5,6);
        blockStateModelGenerator.registerParentedItemModel(ModItems.CHOMPER_SPAWN_EGG,ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.EXAMPLE_ENTITY_EGG,ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

    }

    private void registerLamp(BlockStateModelGenerator blockStateModelGenerator){
        Identifier identifier = Models.CUBE_ALL.upload(ModBlocks.TANZANITE_LAMP,"_off",TextureMap.all(TextureMap.getSubId(ModBlocks.TANZANITE_LAMP,"_off")),blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.TANZANITE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.TANZANITE_LAMP).coordinate(BlockStateModelGenerator.createBooleanModelMap(TanzaniteLampBlock.LIT, identifier2, identifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.EGGPLANT,Models.GENERATED);
        itemModelGenerator.register(ModFluids.SOAP_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TANZANITE_PICKAXE,Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GEM_INFUSING_STATION.asItem(), registerItemBlockModel(ModBlocks.GEM_INFUSING_STATION));
        itemModelGenerator.register(ModBlocks.RAW_RUBY_BLOCK.asItem(),registerItemBlockModel(ModBlocks.RAW_RUBY_BLOCK));
        itemModelGenerator.register(ModBlocks.RUBY_BLOCK.asItem(), registerItemBlockModel(ModBlocks.RUBY_BLOCK));
        itemModelGenerator.register(ModBlocks.RUBY_ORE.asItem(), registerItemBlockModel(ModBlocks.RUBY_ORE));
        itemModelGenerator.register(ModBlocks.DEEPSLATE_RUBY_ORE.asItem(), registerItemBlockModel(ModBlocks.DEEPSLATE_RUBY_ORE));
        itemModelGenerator.register(ModBlocks.NETHER_RUBY_ORE.asItem(), registerItemBlockModel(ModBlocks.NETHER_RUBY_ORE));
        itemModelGenerator.register(ModBlocks.END_STONE_RUBY_ORE.asItem(), registerItemBlockModel(ModBlocks.END_STONE_RUBY_ORE));
        itemModelGenerator.register(ModBlocks.SIMPLE_BLOCK.asItem(), registerItemBlockModel(ModBlocks.SIMPLE_BLOCK));
        itemModelGenerator.register(ModBlocks.TANZANITE_LAMP.asItem(), new Model(Optional.of(new Identifier(TutorialMod.MOD_ID,ModelIds.getBlockModelId(ModBlocks.TANZANITE_LAMP).getPath() + "_off")),Optional.empty()));
    }

    private static Model registerItemBlockModel(Block parent, TextureKey ... requiredTextureKeys) {
        String name = ModelIds.getBlockModelId(parent).getPath();
        return new Model(Optional.of(new Identifier(TutorialMod.MOD_ID, name)), Optional.empty(), requiredTextureKeys);
    }
}

