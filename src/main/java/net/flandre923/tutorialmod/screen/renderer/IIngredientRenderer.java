package net.flandre923.tutorialmod.screen.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;

import java.util.List;

public interface IIngredientRenderer<T> {
    //
    default void render(DrawContext context,T ingredient){
        render(context,0,0,ingredient);
    }

    List<Text> getTooltip(T ingredient, TooltipContext tooltipContext);
    // 返回渲染的textRenderer
    default TextRenderer getFontRenderer(MinecraftClient client,T ingredient){
        return client.textRenderer;
    }
    // 渲染的宽度
    default int getWidth(){
        return 16;
    }
    // 渲染的高度
    default int getHeight(){
        return 16;
    }
    //
    default void render(DrawContext context,int xPosition,int yPosition,T ingredient){

    }

}
