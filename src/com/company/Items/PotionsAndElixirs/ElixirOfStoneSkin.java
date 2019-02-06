package com.company.Items.PotionsAndElixirs;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class ElixirOfStoneSkin extends Elixir{

    private final int DEFENCE_BONUS = 4;

    @Override
    protected void startEffect() {
        CaveExplorer.getPlayerCharacter().setDefence(CaveExplorer.getPlayerCharacter().getDefence()+DEFENCE_BONUS);
    }

    @Override
    protected void ongoingEffect() {
        // none
    }

    @Override
    protected void endEffect() {
        CaveExplorer.getPlayerCharacter().setDefence(CaveExplorer.getPlayerCharacter().getDefence()-DEFENCE_BONUS);
    }

    public ElixirOfStoneSkin(){
        setName("Elixir of Stone Skin");
        setImage(ImageBank.getItemTiles1(),7,5);
        duration = 5000;
        effectIncrement = Integer.MAX_VALUE; // no ongoing effect
    }
}