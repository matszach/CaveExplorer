package com.company.Crafting.PlaceableObjects;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.EnchantingStation;
import com.company.Resources.ResourceType;

final public class Recipe_EnchantingStation extends CraftingRecipe {
    public Recipe_EnchantingStation(){
        super(EnchantingStation.class);
        setRequiredResource(ResourceType.COBALT,15);
        setRequiredResource(ResourceType.GOLD, 10);
    }
}