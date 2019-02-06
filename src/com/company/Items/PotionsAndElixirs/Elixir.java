package com.company.Items.PotionsAndElixirs;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import javafx.animation.AnimationTimer;

abstract public class Elixir extends Item implements IUsableOnButtonPressed {

    protected int duration;
    protected int effectIncrement;

    abstract protected void startEffect();
    abstract protected void ongoingEffect();
    abstract protected void endEffect();


    private AnimationTimer effect = new AnimationTimer() {

        int currentRotation = 0;

        @Override
        public void handle(long now) {

            if(currentRotation == 0){
                startEffect();
            } else if (currentRotation % effectIncrement == 0){
                ongoingEffect();
            } else if (currentRotation == duration){
                endEffect();
                stop();
            }

            currentRotation++;

        }
    };

    @Override
    public boolean usageInProgress() {
        return false;
    }

    @Override
    public void usage(PlayerCharacter playerCharacter) {
        effect.start();
        playerCharacter.getInventory().removeSpecificItem(this);
    }
}
