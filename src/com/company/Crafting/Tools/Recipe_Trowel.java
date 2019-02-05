package com.company.Crafting.Tools;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.BlockPlacers.Trowel;
import com.company.Resources.ResourceType;

final public class Recipe_Trowel extends CraftingRecipe {
    public Recipe_Trowel(){
        super(Trowel.class);
        setRequiredResource(ResourceType.IRON,5);
    }
}