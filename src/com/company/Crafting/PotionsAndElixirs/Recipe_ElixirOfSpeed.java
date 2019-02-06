package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.ElixirOfSpeed;
import com.company.Items.PotionsAndElixirs.FlaskOfWater;
import com.company.Resources.ResourceType;

final public class Recipe_ElixirOfSpeed extends CraftingRecipe{
    public Recipe_ElixirOfSpeed(){
        super(ElixirOfSpeed.class);
        setRequiredResource(ResourceType.SULFUR,10);
        getRequiredItems().add(FlaskOfWater.class);
    }
}