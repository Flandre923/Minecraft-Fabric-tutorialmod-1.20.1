package net.flandre923.tutorialmod.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.flandre923.tutorialmod.networking.ModMessage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.logging.log4j.core.jmx.Server;

public class ThirstData {
    public static int addThirst(IEntityDataSaver player,int amount){
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");
        thirst = Math.min(thirst + amount,10);
        nbt.putInt("thirst",thirst);
        syncThirst(thirst,(ServerPlayerEntity) player);
        return thirst;
    }

    public static int removeThirst(IEntityDataSaver player,int amount){
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");
        thirst = Math.max(0,thirst - amount);
        nbt.putInt("thirst",thirst);
        syncThirst(thirst,(ServerPlayerEntity) player);
        return thirst;
    }

    public static void syncThirst(int thirst, ServerPlayerEntity player){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(thirst);
        ServerPlayNetworking.send(player, ModMessage.THIRST_SYNC_ID,buf);
    }
}
