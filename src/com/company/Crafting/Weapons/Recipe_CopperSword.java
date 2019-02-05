package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Swords.CopperSword;
import com.company.Resources.ResourceType;

final public class Recipe_CopperSword extends CraftingRecipe {
    public Recipe_CopperSword(){
        super(CopperSword.class);
        setRequiredResource(ResourceType.COPPER,15);
    }
}