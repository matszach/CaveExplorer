package com.company.Crafting.Weapons;

import com.company.Crafting.CraftingRecipe;
import com.company.Items.Swords.CobaltSword;
import com.company.Items.Swords.IronSword;
import com.company.Resources.ResourceType;

final public class Recipe_CobaltSword extends CraftingRecipe {
    public Recipe_CobaltSword(){
        super(CobaltSword.class);
        setRequiredResource(ResourceType.COBALT, 15);
        getRequiredItems().add(IronSword.class);
    }
}