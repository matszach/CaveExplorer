package com.company.Crafting.Tools;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Drills.CobaltDrill;
import com.company.Items.Drills.IronDrill;
import com.company.Resources.ResourceType;

final public class Recipe_CobaltDrill extends CraftingRecipe {
    public Recipe_CobaltDrill(){
        super(CobaltDrill.class);
        setRequiredResource(ResourceType.COBALT,20);
        getRequiredItems().add(IronDrill.class);
    }
}