package com.company.Crafting.PlaceableObjects;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.Workshop;
import com.company.Resources.ResourceType;

final public class Recipe_Workshop extends CraftingRecipe {
    public Recipe_Workshop(){
        super(Workshop.class);
        setRequiredResource(ResourceType.STONE,25);
    }
}