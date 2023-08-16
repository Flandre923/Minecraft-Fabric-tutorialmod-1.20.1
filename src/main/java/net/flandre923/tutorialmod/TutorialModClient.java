package net.flandre923.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.block.entity.ModBlockEntities;
import net.flandre923.tutorialmod.block.entity.client.ExampleAnimationBlockRenderer;
import net.flandre923.tutorialmod.block.entity.client.GemInfusingStationBlockEntityRenderer;
import net.flandre923.tutorialmod.client.ThirstHudOverlay;
import net.flandre923.tutorialmod.entity.ModEntities;
import net.flandre923.tutorialmod.entity.client.ChomperRenderer;
import net.flandre923.tutorialmod.entity.client.ExampleEntityRenderer;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.flandre923.tutorialmod.event.KeyInputHandler;
import net.flandre923.tutorialmod.fluid.ModFluids;
import net.flandre923.tutorialmod.networking.ModMessage;
import net.flandre923.tutorialmod.screen.GemInfusingScreen;
import net.flandre923.tutorialmod.screen.ModScreenHandlers;
import net.flandre923.tutorialmod.util.ThirstData;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.GeckoLib;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

        KeyInputHandler.register();
        ModMessage.registerC2SPackets();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());

        //fluid
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER,ModFluids.FLOWING_SOAP_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA1E038D0
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.FLOWING_SOAP_WATER,ModFluids.STILL_SOAP_WATER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_SAPLING,RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUTTERCUPS,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BUTTERCUPS,RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GEM_INFUSING_SCREEN_HANDLER, GemInfusingScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.GEM_INFUSING_STATION,
                GemInfusingStationBlockEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);
        EntityRendererRegistry.register(ModEntities.EXAMPLE_ENTITY, ExampleEntityRenderer::new);


        BlockEntityRendererFactories.register(ModBlockEntities.EXAMPLE_ANIMATION_BLOCK_ENTITY, ExampleAnimationBlockRenderer::new);

    }
}
