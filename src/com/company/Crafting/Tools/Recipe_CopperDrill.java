package com.company.Crafting.Tools;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Drills.CopperDrill;
import com.company.Resources.ResourceType;

final public class Recipe_CopperDrill extends CraftingRecipe {
    public Recipe_CopperDrill(){
        super(CopperDrill.class);
        setRequiredResource(ResourceType.COPPER,20);
    }
}