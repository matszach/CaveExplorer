package com.company.Crafting.PotionsAndElixirs;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PotionsAndElixirs.ElixirOfRegeneration;
import com.company.Items.PotionsAndElixirs.FlaskOfWater;
import com.company.Resources.ResourceType;

public class Recipe_ElixirOfRegeneration extends CraftingRecipe {
    public Recipe_ElixirOfRegeneration(){
        super(ElixirOfRegeneration.class);
        setRequiredResource(ResourceType.GOLD,5);
        setRequiredResource(ResourceType.PLATINUM,5);
        getRequiredItems().add(FlaskOfWater.class);
    }
}