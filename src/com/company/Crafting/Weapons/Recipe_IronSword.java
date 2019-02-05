package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Swords.CopperSword;
import com.company.Items.Swords.IronSword;
import com.company.Resources.ResourceType;

final public class Recipe_IronSword extends CraftingRecipe {
    public Recipe_IronSword(){
        super(IronSword.class);
        setRequiredResource(ResourceType.IRON, 15);
        getRequiredItems().add(CopperSword.class);
    }
}