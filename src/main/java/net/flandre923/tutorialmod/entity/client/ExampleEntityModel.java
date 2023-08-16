package net.flandre923.tutorialmod.entity.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.flandre923.tutorialmod.entity.custom.ExampleEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExampleEntityModel extends GeoModel<ExampleEntity> {
    @Override
    public Identifier getModelResource(ExampleEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"geo/example_entity.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExampleEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"textures/entity/example_entity.png");
    }

    @Override
    public Identifier getAnimationResource(ExampleEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"animations/example_entity.animation.json");
    }
}
