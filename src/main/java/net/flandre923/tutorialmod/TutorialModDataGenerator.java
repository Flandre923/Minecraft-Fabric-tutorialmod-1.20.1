package net.flandre923.tutorialmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.flandre923.tutorialmod.datagen.*;
import net.flandre923.tutorialmod.world.feature.ModConfiguredFeatures;
import net.flandre923.tutorialmod.world.feature.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint  {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModLanguageGenerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModLootTableGeneration::new);
		pack.addProvider(ModBlockTagGeneration::new);
		pack.addProvider(ModVillagerPointOfInterestType::new);
		pack.addProvider(ModPaintingVariantTagGenerator::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModFluidTagGeneration::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
