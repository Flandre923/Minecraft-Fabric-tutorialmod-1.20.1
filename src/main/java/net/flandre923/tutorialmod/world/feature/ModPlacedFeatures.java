package net.flandre923.tutorialmod.world.feature;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import techreborn.blockentity.machine.tier2.PumpBlockEntity;

import java.util.List;


public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RUBY_PLACE_ORE_KEY = registerKey("ruby_ore_placed");
    public static final RegistryKey<PlacedFeature> RED_MAPLE_PLACED_KEY = registerKey("red_maple_place");
    public static final RegistryKey<PlacedFeature> RUBY_GEODE_PLACED = registerKey("ruby_geode_place");
    public static final RegistryKey<PlacedFeature> BUTTERCUPS_PLACED = registerKey("buttercups_placed");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID,name));
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,BUTTERCUPS_PLACED,registryEntryLookup.getOrThrow(ModConfiguredFeatures.BUTTERCUPS_KEY),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,BiomePlacementModifier.of());


        register(context,RUBY_GEODE_PLACED,registryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_GEODE),
                RarityFilterPlacementModifier.of(24), // 生成权重
                SquarePlacementModifier.of(), // 方形修改器
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), //
                        YOffset.fixed(30)), BiomePlacementModifier.of());

        // 在可以存货树的位置生成树，数量，额外的概率，额外的数量。
        register(context,RED_MAPLE_PLACED_KEY,registryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_MAPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),
                        ModBlocks.RED_MAPLE_SAPLING));

        register(context,RUBY_PLACE_ORE_KEY,registryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(16,HeightRangePlacementModifier.uniform(YOffset.fixed(-80),YOffset.fixed(80))));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}

