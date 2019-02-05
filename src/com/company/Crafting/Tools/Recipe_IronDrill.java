package com.company.Crafting.Tools;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Drills.CopperDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Resources.ResourceType;

final public class Recipe_IronDrill extends CraftingRecipe {
    public Recipe_IronDrill(){
        super(IronDrill.class);
        setRequiredResource(ResourceType.IRON,20);
        getRequiredItems().add(CopperDrill.class);
    }
}