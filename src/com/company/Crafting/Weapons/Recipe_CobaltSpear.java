package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.Spears.CobaltSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Resources.ResourceType;

final public class Recipe_CobaltSpear extends CraftingRecipe {
    public Recipe_CobaltSpear(){
        super(CobaltSpear.class);
        setRequiredResource(ResourceType.COBALT, 15);
        getRequiredItems().add(IronSpear.class);
        getRequiredItems().add(WoodenSupport.class);
    }
}
