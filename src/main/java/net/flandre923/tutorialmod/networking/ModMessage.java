package net.flandre923.tutorialmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.networking.packet.*;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

public class ModMessage {
    public static final Identifier DRINKING_ID = new Identifier(TutorialMod.MOD_ID,"drinking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(TutorialMod.MOD_ID,"thirst_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(TutorialMod.MOD_ID,"example");
    public static final Identifier ENERGY_SYNC = new Identifier(TutorialMod.MOD_ID,"energy_sync");
    public static final Identifier FLUID_SYNC  = new Identifier(TutorialMod.MOD_ID,"fluid_sync");
    public static final Identifier ITEM_SYNC = new Identifier(TutorialMod.MOD_ID,"item_sync");
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(THIRST_SYNC_ID, ThirstSyncDataS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2Packet::receive);
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC,ItemStackSyncS2CPacket::receive);
    }
}
