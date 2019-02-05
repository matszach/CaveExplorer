package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.Spears.CopperSpear;
import com.company.Items.Spears.IronSpear;
import com.company.Resources.ResourceType;

final public class Recipe_IronSpear extends CraftingRecipe {
    public Recipe_IronSpear(){
        super(IronSpear.class);
        setRequiredResource(ResourceType.IRON, 15);
        getRequiredItems().add(CopperSpear.class);
        getRequiredItems().add(WoodenSupport.class);
    }
}
