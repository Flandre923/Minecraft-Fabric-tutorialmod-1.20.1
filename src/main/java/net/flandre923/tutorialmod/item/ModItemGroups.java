package net.flandre923.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.fluid.ModFluids;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final String TUTORIAL_TAB = "itemgroup.ruby";
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"ruby"),
            FabricItemGroup.builder().displayName(Text.translatable(TUTORIAL_TAB))
                    .icon(()->new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.EGGPLANT);
                        entries.add(ModItems.EGGPLANT_SEEDS);
                        entries.add(ModFluids.SOAP_WATER_BUCKET);
                        entries.add(ModItems.TUTORIAL_HAMMER);
                        entries.add(ModBlocks.GEM_INFUSING_STATION);
                        entries.add(ModItems.CHOMPER_SPAWN_EGG);
                        entries.add(ModItems.TANZANITE_PICKAXE);
                        entries.add(ModItems.EXAMPLE_ANIMATION_ITEM);
                        entries.add(ModItems.EXAMPLE_ANIMATION_BLOCK);


                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);
                        entries.add(ModBlocks.SIMPLE_BLOCK);
                        entries.add(ModBlocks.TANZANITE_LAMP);
                        entries.add(ModBlocks.RED_MAPLE_LEAVES);
                        entries.add(ModBlocks.RED_MAPLE_LOG);
                        entries.add(ModBlocks.RED_MAPLE_PLANKS);
                        entries.add(ModBlocks.RED_MAPLE_SAPLING);
                        entries.add(ModBlocks.RED_MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_RED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_RED_MAPLE_WOOD);
                        entries.add(ModBlocks.TERRA_CONDENSATION);
                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Group for " + TutorialMod.MOD_ID);
    }
}
