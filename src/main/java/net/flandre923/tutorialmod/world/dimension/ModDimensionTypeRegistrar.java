package net.flandre923.tutorialmod.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensionTypeRegistrar {
    public static void bootstrap(Registerable<DimensionType> dimensionTypeRegisterable) {
        dimensionTypeRegisterable.register(ModDimensionTypes.MY_WORLD, new DimensionType(OptionalLong.empty(), true, true, false, true, 1.0, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, ModDimensionTypes.MY_WORLD_ID, 0.0f, new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)));

    }
}
