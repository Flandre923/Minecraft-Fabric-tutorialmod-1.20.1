package net.flandre923.tutorialmod.world.dimension;

import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionOptions;

public class ModDimensionOptions {
    public static final RegistryKey<DimensionOptions> MY_WORLD = RegistryKey.of(RegistryKeys.DIMENSION, new Identifier(TutorialMod.MOD_ID,"my_world"));

}
