package net.flandre923.tutorialmod.recipe;


import net.flandre923.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER,new Identifier(TutorialMod.MOD_ID,GemInfusingRecipe.Serializer.ID),
                GemInfusingRecipe.Serializer.INSTANCE);

        Registry.register(Registries.RECIPE_TYPE,new Identifier(TutorialMod.MOD_ID,GemInfusingRecipe.Type.ID),
                GemInfusingRecipe.Type.INSTANCE);


    }
}
