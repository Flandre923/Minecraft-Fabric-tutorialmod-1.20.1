package net.flandre923.tutorialmod.item.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.entity.ExampleAnimationBlockEntity;
import net.flandre923.tutorialmod.item.custom.ExampleAnimationBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExampleAnimationBlockItemModel extends GeoModel<ExampleAnimationBlockItem> {
    @Override
    public Identifier getModelResource(ExampleAnimationBlockItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "geo/example_animation_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExampleAnimationBlockItem animatable) {
        return  new Identifier(TutorialMod.MOD_ID, "textures/block/example_aniamtion_block.png");
    }

    @Override
    public Identifier getAnimationResource(ExampleAnimationBlockItem animatable) {
        return  new Identifier(TutorialMod.MOD_ID, "animations/example_aniamtion_block.animation.json");
    }
}
