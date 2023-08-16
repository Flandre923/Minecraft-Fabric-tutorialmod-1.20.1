package net.flandre923.tutorialmod.item.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.item.custom.ExampleAnimationItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExampleAnimationItemModel extends GeoModel<ExampleAnimationItem> {
    @Override
    public Identifier getModelResource(ExampleAnimationItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "geo/example_animation_item.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExampleAnimationItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "textures/item/example_animation_item.png");
    }

    @Override
    public Identifier getAnimationResource(ExampleAnimationItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/example_aniamtion_item.animation.json");
    }
}
