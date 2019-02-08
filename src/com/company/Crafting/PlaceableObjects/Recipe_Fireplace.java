package com.company.Crafting.PlaceableObjects;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.Fireplace;

import com.company.Resources.ResourceType;

public class Recipe_Fireplace extends CraftingRecipe {
    public Recipe_Fireplace(){
        super(Fireplace.class);
        setRequiredResource(ResourceType.STONE,5);
        setRequiredResource(ResourceType.COAL, 10);
    }
}