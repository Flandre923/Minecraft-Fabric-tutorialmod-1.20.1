package net.flandre923.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.flandre923.tutorialmod.datagen.provider.PointOfInterestTagProvider;
import net.flandre923.tutorialmod.villager.ModVillagers;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModVillagerPointOfInterestType extends PointOfInterestTagProvider {

    public ModVillagerPointOfInterestType(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .add(ModVillagers.JUMPY_POI);
    }

}
