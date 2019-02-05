package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Daggers.CopperDagger;
import com.company.Resources.ResourceType;

final public class Recipe_CopperDagger extends CraftingRecipe {
    public Recipe_CopperDagger(){
        super(CopperDagger.class);
        setRequiredResource(ResourceType.COPPER, 5);
    }
}
