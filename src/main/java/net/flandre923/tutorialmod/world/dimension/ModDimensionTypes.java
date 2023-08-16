package net.flandre923.tutorialmod.world.dimension;

import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

public class ModDimensionTypes {

    public static final RegistryKey<DimensionType> MY_WORLD = ModDimensionTypes.of("my_world");
    public static final Identifier MY_WORLD_ID = new Identifier(TutorialMod.MOD_ID,"my_world");

    private static RegistryKey<DimensionType> of(String id) {
        return RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(TutorialMod.MOD_ID,id));
    }

}
