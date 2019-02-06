package com.company.Items.PotionsAndElixirs;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class ElixirOfSpeed extends Elixir{


    private final double SPEED_BONUS = 0.0625;

    @Override
    protected void startEffect() {
        CaveExplorer.getPlayerCharacter().setMovementSpeed(CaveExplorer.getPlayerCharacter().getMovementSpeed()+ SPEED_BONUS);
    }

    @Override
    protected void ongoingEffect() {
        // none
    }

    @Override
    protected void endEffect() {
        CaveExplorer.getPlayerCharacter().setMovementSpeed(CaveExplorer.getPlayerCharacter().getMovementSpeed()- SPEED_BONUS);
    }

    public ElixirOfSpeed(){
        setName("Elixir of Speed");
        setImage(ImageBank.getItemTiles1(),7,3);
        duration = 1000;
        effectIncrement = Integer.MAX_VALUE; // no ongoing effect
    }
}
