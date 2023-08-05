package net.flandre923.tutorialmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.flandre923.tutorialmod.world.feature.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModGeodeGeneration {

    public static void generateGeode(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.RUBY_GEODE_PLACED);
    }
}
