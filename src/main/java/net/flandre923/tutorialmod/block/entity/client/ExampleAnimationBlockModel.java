package net.flandre923.tutorialmod.block.entity.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.entity.ExampleAnimationBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExampleAnimationBlockModel extends GeoModel<ExampleAnimationBlockEntity> {
    @Override
    public Identifier getModelResource(ExampleAnimationBlockEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "geo/example_animation_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExampleAnimationBlockEntity animatable) {
        return  new Identifier(TutorialMod.MOD_ID, "textures/block/example_aniamtion_block.png");
    }

    @Override
    public Identifier getAnimationResource(ExampleAnimationBlockEntity animatable) {
        return  new Identifier(TutorialMod.MOD_ID, "animations/example_aniamtion_block.animation.json");
    }
}
