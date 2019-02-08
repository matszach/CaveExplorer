package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Staves.SilverStaff;
import com.company.Resources.ResourceType;

final public class Recipe_GoldStaff extends CraftingRecipe {
    public Recipe_GoldStaff(){
        super(SilverStaff.class);
        setRequiredResource(ResourceType.BLOOD_RUBY, 5);
        setRequiredResource(ResourceType.GOLD, 20);
        setRequiredResource(ResourceType.SULFUR, 10);
    }
}