package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Staves.PlatinumStaff;

import com.company.Resources.ResourceType;

final public class Recipe_PlatinumStaff extends CraftingRecipe {
    public Recipe_PlatinumStaff(){
        super(PlatinumStaff.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 5);
        setRequiredResource(ResourceType.PLATINUM, 30);
    }
}