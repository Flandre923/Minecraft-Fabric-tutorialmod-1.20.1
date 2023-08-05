package net.flandre923.tutorialmod.screen;

import net.flandre923.tutorialmod.block.entity.GemInfusingBlockEntity;
import net.flandre923.tutorialmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class GemInfusingScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final GemInfusingBlockEntity blockEntity;
    public FluidStack fluidStack;


    public GemInfusingScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId,playerInventory,playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),new SimpleInventory(3),new ArrayPropertyDelegate(2));
    }

    public GemInfusingScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,Inventory inventory, PropertyDelegate delegate){
        super(ModScreenHandlers.GEM_INFUSING_SCREEN_HANDLER,syncId);
        checkSize(inventory,3);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;
        this.blockEntity = (GemInfusingBlockEntity) entity;
        this.fluidStack = new FluidStack(blockEntity.fluidStorage.variant,blockEntity.fluidStorage.amount);


        this.addSlot(new Slot(inventory,0,12,15));
        this.addSlot(new Slot(inventory,1,86,15));
        this.addSlot(new Slot(inventory, 2, 86,60));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public void setFluid(FluidStack stack){
        fluidStack = stack;
    }

    public boolean isCrafting(){
        return propertyDelegate.get(0) > 0 ;
    }

    public int getScaledProgress(){
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 26;

        return maxProgress != 0 && progress!=0?progress * progressArrowSize/maxProgress:0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int i=0;i<3;i++){
            for(int l=0;l<9;l++){
                this.addSlot(new Slot(playerInventory,l+i * 9 + 9,8+l*18,86+i*18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory inventory){
        for(int i = 0;i<9;i++){
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 144));
        }
    }
}
