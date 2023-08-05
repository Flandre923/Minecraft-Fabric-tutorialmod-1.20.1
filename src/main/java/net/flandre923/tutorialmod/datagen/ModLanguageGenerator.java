package net.flandre923.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.event.KeyInputHandler;
import net.flandre923.tutorialmod.fluid.ModFluids;
import net.flandre923.tutorialmod.item.ModItemGroups;
import net.flandre923.tutorialmod.item.ModItems;
import net.flandre923.tutorialmod.networking.packet.DrinkingC2SPacket;
import net.flandre923.tutorialmod.villager.ModVillagers;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;

public class ModLanguageGenerator extends FabricLanguageProvider {
    public ModLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput,"en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RAW_RUBY,"Raw Ruby");
        translationBuilder.add(ModItems.RUBY,"Ruby");
        translationBuilder.add(ModItems.METAL_DETECTOR,"Metal Detector");
        translationBuilder.add(ModItems.EGGPLANT,"Eggplant");
        translationBuilder.add(ModItems.EGGPLANT_SEEDS,"Eggplant Seeds");
        translationBuilder.add(ModBlocks.RUBY_BLOCK,"Ruby Block");
        translationBuilder.add(ModBlocks.RAW_RUBY_BLOCK,"Raw Ruby Block");
        translationBuilder.add(ModBlocks.RUBY_ORE,"Ruby Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_RUBY_ORE,"Deepslate Ruby Ore");
        translationBuilder.add(ModBlocks.END_STONE_RUBY_ORE,"End Stone Ruby Ore");
        translationBuilder.add(ModBlocks.NETHER_RUBY_ORE,"Nether Ruby Ore");
        translationBuilder.add(ModBlocks.SIMPLE_BLOCK,"Simple Block");
        translationBuilder.add(ModBlocks.TANZANITE_LAMP,"Tanzanite Lamp");
        translationBuilder.add(ModBlocks.GEM_INFUSING_STATION,"Gem Infusing Station");
        translationBuilder.add(ModFluids.SOAP_WATER_BUCKET,"Soap Water Bucket");
        translationBuilder.add(ModItems.TUTORIAL_HAMMER,"Tutorial Hammer");
        translationBuilder.add(ModItems.CHOMPER_SPAWN_EGG,"Chomper Spawn Egg");
        translationBuilder.add(ModItems.TANZANITE_PICKAXE,"Ruby Pickaxe");
        translationBuilder.add(ModBlocks.RED_MAPLE_LOG,"Red Maple Log");
        translationBuilder.add(ModBlocks.RED_MAPLE_WOOD,"Red Maple Wood");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_LOG,"Stripped Red Maple Log");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_WOOD,"stripped Red Maple wood");
        translationBuilder.add(ModBlocks.RED_MAPLE_PLANKS,"Red Maple Planks");
        translationBuilder.add(ModBlocks.RED_MAPLE_LEAVES,"Red Maple Leaves");
        translationBuilder.add(ModBlocks.RED_MAPLE_SAPLING,"Red Maple Sapling");
        translationBuilder.add(ModBlocks.BUTTERCUPS,"Buttercups");


        translationBuilder.add("block.tutorialmod:soap_water","Soap Water"); // %d  --> int  %f -->float/double
        translationBuilder.add("tutorialmod.tooltip.liquid.amount.with.capacity","%s / %s mB");
        translationBuilder.add("tutorialmod.tooltip.liquid.amount","%s mB");

        translationBuilder.add(KeyInputHandler.KEY_CATEGORY_TUTORIAL,"Tutorial Mod");
        translationBuilder.add(KeyInputHandler.KEY_DRINK_WATER,"Drink Water Key");

        translationBuilder.add(DrinkingC2SPacket.MESSAGE_NO_WATER_NEARBY,"No Water around");
        translationBuilder.add(DrinkingC2SPacket.MESSAGE_DRINKING_WATER,"Drinking Water");
        translationBuilder.add(ModItemGroups.TUTORIAL_TAB,"Tutorial Mod Tab");
        translationBuilder.add("entity.minecraft.villager.jumpmaster","Jump Master");
    }
}
