package net.flandre923.tutorialmod.entity.client;

import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.flandre923.tutorialmod.entity.custom.ExampleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ExampleEntityRenderer extends GeoEntityRenderer<ExampleEntity> {
    public ExampleEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ExampleEntityModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(ExampleEntity chomperEntity) {
        return  new Identifier(TutorialMod.MOD_ID,"textures/entity/example_entity.png");
    }

    @Override
    public void render(ExampleEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(0.8f,0.8f,0.8f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
