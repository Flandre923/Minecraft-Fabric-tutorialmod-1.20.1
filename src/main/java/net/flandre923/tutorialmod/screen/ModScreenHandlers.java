package net.flandre923.tutorialmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<GemInfusingScreenHandler> GEM_INFUSING_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(GemInfusingScreenHandler::new);

    public static void registerAllScreenHandlers(){
            Registry.register(Registries.SCREEN_HANDLER,
                new Identifier(TutorialMod.MOD_ID,"gem_infusing"),
                GEM_INFUSING_SCREEN_HANDLER);
    }
}
