package net.flandre923.tutorialmod.block.entity.client;

import net.flandre923.tutorialmod.block.entity.ExampleAnimationBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ExampleAnimationBlockRenderer extends GeoBlockRenderer<ExampleAnimationBlockEntity> {
    public ExampleAnimationBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new ExampleAnimationBlockModel());
    }
}
