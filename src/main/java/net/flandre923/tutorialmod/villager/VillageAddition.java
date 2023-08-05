package net.flandre923.tutorialmod.villager;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;

public class VillageAddition {
    public static void registerNetVillageStructures(){
        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(TutorialMod.MOD_ID,"example_village_house"),
                150
        );
    }
}
