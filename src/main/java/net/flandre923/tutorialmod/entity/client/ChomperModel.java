package net.flandre923.tutorialmod.entity.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ChomperModel extends GeoModel<ChomperEntity> {
    @Override
    public Identifier getModelResource(ChomperEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"geo/chomper.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChomperEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"textures/entity/chomper_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ChomperEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID,"animations/chomper.animation.json");
    }
}
