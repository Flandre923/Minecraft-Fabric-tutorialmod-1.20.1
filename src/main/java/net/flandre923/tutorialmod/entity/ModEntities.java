package net.flandre923.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.flandre923.tutorialmod.entity.custom.ExampleEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<ChomperEntity> CHOMPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID,"chomper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,ChomperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f,1.5f)).build());

    public static final EntityType<ExampleEntity> EXAMPLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID,"example_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ExampleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f,1.5f)).build());
}
