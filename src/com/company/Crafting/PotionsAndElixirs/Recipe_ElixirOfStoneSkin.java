package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.ElixirOfStoneSkin;
import com.company.Items.PotionsAndElixirs.FlaskOfWater;
import com.company.Resources.ResourceType;

final public class Recipe_ElixirOfStoneSkin extends CraftingRecipe {
    public Recipe_ElixirOfStoneSkin(){
        super(ElixirOfStoneSkin.class);
        setRequiredResource(ResourceType.STONE, 10);
        setRequiredResource(ResourceType.IRON, 5);
        getRequiredItems().add(FlaskOfWater.class);
    }
}
