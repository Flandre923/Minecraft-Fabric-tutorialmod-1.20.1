package net.flandre923.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.flandre923.tutorialmod.datagen.provider.PaintingTagProvider;
import net.flandre923.tutorialmod.painting.ModPaintings;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagGenerator extends PaintingTagProvider {
    public ModPaintingVariantTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .add(ModPaintings.PLANT)
                .add(ModPaintings.SUNSET)
                .add(ModPaintings.WANDERER);
    }
}
