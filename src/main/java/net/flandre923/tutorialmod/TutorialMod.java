package net.flandre923.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.flandre923.tutorialmod.block.ModBlocks;
import net.flandre923.tutorialmod.block.ModFlammableBlockRegistry;
import net.flandre923.tutorialmod.block.entity.ModBlockEntities;
import net.flandre923.tutorialmod.entity.ModEntities;
import net.flandre923.tutorialmod.entity.custom.ChomperEntity;
import net.flandre923.tutorialmod.entity.custom.ExampleEntity;
import net.flandre923.tutorialmod.event.AttackEntityHandler;
import net.flandre923.tutorialmod.event.PlayerTickHandler;
import net.flandre923.tutorialmod.fluid.ModFluids;
import net.flandre923.tutorialmod.item.ModItemGroups;
import net.flandre923.tutorialmod.item.ModItems;
import net.flandre923.tutorialmod.networking.ModMessage;
import net.flandre923.tutorialmod.painting.ModPaintings;
import net.flandre923.tutorialmod.recipe.ModRecipes;
import net.flandre923.tutorialmod.screen.ModScreenHandlers;
import net.flandre923.tutorialmod.util.ModLootTableModifies;
import net.flandre923.tutorialmod.villager.ModVillagers;
import net.flandre923.tutorialmod.villager.VillageAddition;
import net.flandre923.tutorialmod.world.dimension.ModDimensionTypes;
import net.flandre923.tutorialmod.world.gen.ModOreGeneration;
import net.flandre923.tutorialmod.world.gen.ModWorldGeneration;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

// shift + f6 更改这个类的名字
public class TutorialMod implements ModInitializer {
	// 增加一个MOD_ID字段方便，我们之后的操作
	public static final String MOD_ID = "tutorialmod";
	// 这里换成我们的MOD_ID
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.resisterPaintings();

		ModLootTableModifies.modifyLootTables();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		ModMessage.registerS2CPackets();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_LOG,ModBlocks.STRIPPED_RED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_WOOD,ModBlocks.STRIPPED_RED_MAPLE_WOOD);

		VillageAddition.registerNetVillageStructures();

		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.CHOMPER, ChomperEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.EXAMPLE_ENTITY, ExampleEntity.setAttributes());
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());


		//
		CustomPortalBuilder.beginPortal()
						.frameBlock(Blocks.GOLD_BLOCK)
								.lightWithItem(Items.ENDER_EYE)
										.destDimID(ModDimensionTypes.MY_WORLD_ID)
												.tintColor(234,183,8)
														.registerPortal();

		ModFluids.register();
	}
}