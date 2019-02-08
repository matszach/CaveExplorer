package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;

import com.company.Items.Staves.SilverStaff;
import com.company.Resources.ResourceType;

final public class Recipe_SilverStaff extends CraftingRecipe {
    public Recipe_SilverStaff(){
        super(SilverStaff.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 5);
        setRequiredResource(ResourceType.SILVER, 20);
    }
}