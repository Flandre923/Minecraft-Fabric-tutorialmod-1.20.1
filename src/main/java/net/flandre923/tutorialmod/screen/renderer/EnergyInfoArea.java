package net.flandre923.tutorialmod.screen.renderer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.text.Text;
import team.reborn.energy.api.EnergyStorage;

import java.util.List;

public class EnergyInfoArea extends InfoArea{
    private final EnergyStorage energyStorage;

    public EnergyInfoArea(int xMin,int yMin){
        this(xMin,yMin,null,8,64);
    }
    public EnergyInfoArea(int xMin,int yMin,EnergyStorage energyStorage){
        this(xMin,yMin,energyStorage,8,64);
    }

    public EnergyInfoArea(int xMin,int yMin,EnergyStorage energyStorage,int width,int height) {
        super(new Rect2i(xMin,yMin,width,height));
        this.energyStorage = energyStorage;
    }

    public List<Text> getTooltips(){
        return List.of(Text.literal(energyStorage.getAmount() + "/" +energyStorage.getCapacity() +"E"));
    }

    @Override
    public void draw(DrawContext context) {
        final int height = area.getHeight();
        int stored = (int)(height * (energyStorage.getAmount() / (float)energyStorage.getCapacity()));
        context.fillGradient(area.getX(),area.getY()+(height-stored),
                area.getX()+area.getWidth(),area.getY()+area.getHeight(),
                0xffb51500,0xff600b00);
    }
}
