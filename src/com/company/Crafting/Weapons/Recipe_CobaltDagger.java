package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Daggers.CobaltDagger;
import com.company.Items.Daggers.IronDagger;
import com.company.Resources.ResourceType;

final public class Recipe_CobaltDagger extends CraftingRecipe {
    public Recipe_CobaltDagger(){
        super(CobaltDagger.class);
        setRequiredResource(ResourceType.COBALT, 5);
        getRequiredItems().add(IronDagger.class);
    }
}