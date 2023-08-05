package net.flandre923.tutorialmod.util;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;

public class FluidStack {
    // FluidVariant 类是包含了流体的类型和NBT标签，
    public FluidVariant fluidVariant;
    // 容积
    public long amount;
    // 构造方法，
    public FluidStack(FluidVariant variant,long amount){
        this.fluidVariant = variant;
        this.amount = amount;
    }
    // 返回流体的类型
    public FluidVariant getFluidVariant() {
        return fluidVariant;
    }
    // 设置流体类型
    public void setFluidVariant(FluidVariant variant){
        this.fluidVariant = variant;
    }
    // 返回容积
    public long getAmount(){
        return amount;
    }
    // 设置容积
    public void setAmount(long amount){
        this.amount = amount;
    }
    // 将给定的 滴 转化为 mb
    public static long convertDropletsToMb(long droplets){
        return (droplets/81);
    }
    // 将 mb 转化为 滴
    public static long convertMbToDroplets(long mb){
        return mb*81;
    }



}
