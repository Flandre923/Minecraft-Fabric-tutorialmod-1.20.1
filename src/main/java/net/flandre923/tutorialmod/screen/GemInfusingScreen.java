package net.flandre923.tutorialmod.screen;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.flandre923.tutorialmod.TutorialMod;
import net.flandre923.tutorialmod.screen.renderer.EnergyInfoArea;
import net.flandre923.tutorialmod.screen.renderer.FluidStackRenderer;
import net.flandre923.tutorialmod.util.FluidStack;
import net.flandre923.tutorialmod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class GemInfusingScreen  extends HandledScreen<GemInfusingScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(TutorialMod.MOD_ID,"textures/gui/gem_infusing_station_gui.png");
    private EnergyInfoArea energyInfoArea;
    private FluidStackRenderer fluidStackRenderer;


    public GemInfusingScreen(GemInfusingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth  - textRenderer.getWidth(title)) / 2;
        assignEnergyInfoArea();
        assignFluidStackRenderer();
    }

    private void assignFluidStackRenderer(){
        fluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 20,
                true,15,61);
    }

    private void assignEnergyInfoArea(){
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth) / 2) + 156,
                ((height - backgroundHeight)/2)+13,handler.blockEntity.energyStorage);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight) /2;

        renderEnergyAreaTooltips(context,mouseX,mouseY,x,y);
        renderFluidTooltip(context,mouseX,mouseY,x,y,handler.fluidStack,55,15,fluidStackRenderer);
    }

    private void renderFluidTooltip(DrawContext context,int mouseX,int mouseY,int x,int y,
                                    FluidStack fluidStack,int offsetX,int offsetY,FluidStackRenderer renderer){
        if(isMouseAboveArea(mouseX,mouseY,x,y,offsetX,offsetY,renderer)){
            // 绘制流体的提示信息
            context.drawTooltip(textRenderer,renderer.getTooltip(fluidStack, TooltipContext.Default.BASIC),
                    Optional.empty(),mouseX-x,mouseY-y);
        }
    }



    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) /2;
        context.drawTexture(TEXTURE,x,y,0,0,backgroundWidth,backgroundHeight);
        renderProgressArrow(context,x,y);
        energyInfoArea.draw(context);
        // 绘制流体slot
        fluidStackRenderer.drawFluid(context,handler.fluidStack,x+55,y+15,16,61,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*20);
    }

    private void renderEnergyAreaTooltips(DrawContext context,int pMouseX,int pMouseY,int x,int y){
        if(isMouseAboveArea(pMouseX,pMouseY,x,y,156,13,8,64)){
            context.drawTooltip(textRenderer, energyInfoArea.getTooltips(), Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }
    private void renderProgressArrow(DrawContext context,int x,int y){
        if(handler.isCrafting()){
            context.drawTexture(TEXTURE,x+105,y+33,176,0,8,handler.getScaledProgress());
        }
    }

    private boolean isMouseAboveArea(int MouseX, int MouseY, int x, int y, int offsetX, int offsetY, int width, int height){
        return MouseUtil.isMouseOver(MouseX,MouseY,x+offsetX,y+offsetY,width,height);
    }

    private boolean isMouseAboveArea(int pMouseX,int pMouseY,int x,int y,int offsetX,int offsetY,FluidStackRenderer renderer){
        return MouseUtil.isMouseOver(pMouseX,pMouseY,x+offsetX,y+offsetY,renderer.getWidth(),renderer.getHeight());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
    }

}
