package com.company.Items.PotionsAndElixirs;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;


abstract public class Potion extends Item implements IUsableOnButtonPressed {


    @Override
    public boolean usageInProgress() {
        return false;
    }

    @Override
    public void usage(PlayerCharacter playerCharacter) {
        takeEffect();
        playerCharacter.getInventory().removeSpecificItem(this);
    }

    abstract void takeEffect();

}
