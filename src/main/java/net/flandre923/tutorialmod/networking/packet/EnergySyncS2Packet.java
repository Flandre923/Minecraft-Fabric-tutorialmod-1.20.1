package net.flandre923.tutorialmod.networking.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.flandre923.tutorialmod.block.entity.GemInfusingBlockEntity;
import net.flandre923.tutorialmod.screen.GemInfusingScreenHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public class EnergySyncS2Packet {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender sender){

        long energy = buf.readLong();
        BlockPos pos  = buf.readBlockPos();

        if(client.world.getBlockEntity(pos) instanceof GemInfusingBlockEntity entity){
            entity.setEnergyStorage(energy);

            if(client.player.currentScreenHandler instanceof  GemInfusingScreenHandler screenHandler &&
            screenHandler.blockEntity.getPos().equals(pos)){
                entity.setEnergyStorage(energy);
            }
        }
    }
}
