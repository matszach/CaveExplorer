package com.company.Items.PotionsAndElixirs;

import com.company.CaveExplorer;
import com.company.ImageBank;

final public class ElixirOfRegeneration extends Elixir{

    @Override
    protected void startEffect() {
        // none
    }

    @Override
    protected void ongoingEffect() {
        CaveExplorer.getPlayerCharacter().healDamage(1);
    }

    @Override
    protected void endEffect() {
       // none
    }

    public ElixirOfRegeneration(){
        setName("Elixir of Regeneration");
        setImage(ImageBank.getItemTiles1(),7,4);
        duration = 5000;
        effectIncrement = 50;
    }
}
