package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Daggers.CopperDagger;
import com.company.Items.Daggers.IronDagger;
import com.company.Resources.ResourceType;


final public class Recipe_IronDagger extends CraftingRecipe {

    public Recipe_IronDagger(){
        super(IronDagger.class);
        setRequiredResource(ResourceType.IRON, 5);
        getRequiredItems().add(CopperDagger.class);
    }
}