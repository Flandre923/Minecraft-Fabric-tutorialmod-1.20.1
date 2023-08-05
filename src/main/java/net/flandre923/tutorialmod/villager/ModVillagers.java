package net.flandre923.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType JUMPY_POI = registerPOI("jumpy_poi", ModBlocks.SIMPLE_BLOCK);
    public static final VillagerProfession JUMP_MASTER = registerProfession("jumpmaster",
            RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(TutorialMod.MOD_ID,"jumpy_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier(TutorialMod.MOD_ID,name),
                VillagerProfessionBuilder.create().id(new Identifier(TutorialMod.MOD_ID,name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(TutorialMod.MOD_ID,name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers(){
        TutorialMod.LOGGER.info("registering Villagers for " + TutorialMod.MOD_ID);
    }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(JUMP_MASTER,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD,3),
                            new ItemStack(ModItems.METAL_DETECTOR),
                            6,2,0.02f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER,1,
                factories -> new TradeOffer(
                        new ItemStack(Items.EMERALD,3),
                        new ItemStack(Items.DIAMOND,5),
                        6,2,0.02f
                ));
    }

}
