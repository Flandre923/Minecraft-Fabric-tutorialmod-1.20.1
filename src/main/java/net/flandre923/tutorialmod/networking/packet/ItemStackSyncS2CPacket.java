package net.flandre923.tutorialmod.networking.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.flandre923.tutorialmod.block.entity.GemInfusingBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class ItemStackSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender sender){
        int size = buf.readInt();
        DefaultedList<ItemStack> list = DefaultedList.ofSize(size,ItemStack.EMPTY);
        for(int i =0;i<size;i++){
            list.set(i,buf.readItemStack());
        }
        BlockPos pos = buf.readBlockPos();
        if(client.world.getBlockEntity(pos) instanceof GemInfusingBlockEntity block){
            block.setInventory(list);
        }
    }
}
