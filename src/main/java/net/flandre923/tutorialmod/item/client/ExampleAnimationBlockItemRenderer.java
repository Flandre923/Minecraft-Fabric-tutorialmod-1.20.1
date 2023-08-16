package net.flandre923.tutorialmod.item.client;

import net.flandre923.tutorialmod.item.custom.ExampleAnimationBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ExampleAnimationBlockItemRenderer extends GeoItemRenderer<ExampleAnimationBlockItem> {
    public ExampleAnimationBlockItemRenderer() {
        super(new ExampleAnimationBlockItemModel());
    }
}
