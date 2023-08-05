package net.flandre923.tutorialmod.world.gen;

public class ModWorldGeneration {

    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTress();
        ModGeodeGeneration.generateGeode();
        ModFlowerGeneration.generateFlower();

        ModEntitySpawn.addEntitySpawn();
    }
}
