package net.flandre923.tutorialmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.flandre923.tutorialmod.block.entity.GemInfusingBlockEntity;
import net.flandre923.tutorialmod.screen.GemInfusingScreenHandler;
import net.flandre923.tutorialmod.util.FluidStack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public class FluidSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender sender){

        FluidVariant variant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos pos = buf.readBlockPos();

        if(client.world.getBlockEntity(pos) instanceof GemInfusingBlockEntity entity){
            entity.setFluidLevel(variant,fluidLevel);
            if(client.player.currentScreenHandler instanceof GemInfusingScreenHandler screenHandler &&
            screenHandler.blockEntity.getPos().equals(pos)){
                entity.setFluidLevel(variant,fluidLevel);
                screenHandler.setFluid(new FluidStack(variant,fluidLevel));
            }
        }
    }
}
