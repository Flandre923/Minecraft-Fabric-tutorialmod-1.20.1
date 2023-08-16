package net.flandre923.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.entity.ModEntities;
import net.flandre923.tutorialmod.item.custom.ExampleAnimationBlockItem;
import net.flandre923.tutorialmod.item.custom.ExampleAnimationItem;
import net.flandre923.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby",new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem());

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings()));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(4).build())));
    public static final Item TUTORIAL_HAMMER = registerItem("tutorial_stick",
            new SwordItem(ToolMaterials.DIAMOND,10,4,new FabricItemSettings().maxCount(1)));
    public static final Item CHOMPER_SPAWN_EGG = registerItem("chomper_spawn_egg",
            new SpawnEggItem(ModEntities.CHOMPER,0x22b341,0x19732e,
                    new FabricItemSettings()));

    public static final Item TANZANITE_PICKAXE = registerItem("tanzanite_pickaxe",
            new PickaxeItem(ModToolMaterial.TANZANITE,4,2f,
                    new FabricItemSettings()));

    public static final Item EXAMPLE_ENTITY_EGG = registerItem("example_entity_egg",
            new SpawnEggItem(ModEntities.EXAMPLE_ENTITY,0x222222,0x555555,
                    new FabricItemSettings()));

    public static final Item EXAMPLE_ANIMATION_ITEM = registerItem("example_animation_item",
            new ExampleAnimationItem(new FabricItemSettings()));

    public static final Item EXAMPLE_ANIMATION_BLOCK = registerItem("example_animation_block",
            new ExampleAnimationBlockItem(ModBlocks.EXAMPLE_ANIAMTION_BLOCK,new FabricItemSettings()));

    // 处理全部的item 和 搜索的item
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }
    // 注册
    private static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name),item);
    }
    // 打印信息
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Item for" + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
