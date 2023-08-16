package net.flandre923.tutorialmod.item.client;

import net.flandre923.tutorialmod.item.custom.ExampleAnimationItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ExampleAmiationItemRenderer extends GeoItemRenderer<ExampleAnimationItem> {
    public ExampleAmiationItemRenderer() {
        super(new ExampleAnimationItemModel());
    }
}
