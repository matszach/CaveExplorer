package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.PlaceableObjects.WoodenSupport;
import com.company.Items.Spears.CopperSpear;
import com.company.Resources.ResourceType;


final public class Recipe_CopperSpear extends CraftingRecipe {
    public Recipe_CopperSpear(){
        super(CopperSpear.class);
        setRequiredResource(ResourceType.COPPER, 10);
        requiredItems.add(WoodenSupport.class);
    }
}
