package net.flandre923.tutorialmod.screen.renderer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.Rect2i;

public abstract class InfoArea {
    protected final Rect2i area;

    public InfoArea(Rect2i area) {
        this.area = area;
    }

    public abstract void draw(DrawContext context);
}
