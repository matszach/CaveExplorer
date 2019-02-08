package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.ImageBank;
import javafx.animation.AnimationTimer;

public class Tile_Const_Fireplace extends DynamicTile {

    @Override
    void buildBackGround() {
        setImage(ImageBank.getMapTiles1());
        setViewByRowAndCol(7,0);
    }

    private Tile_Const_Fireplace thisTile = this;

    @Override
    protected void setChanges() {

        changes = new AnimationTimer() {

            int time = 0;
            int rotationLength = 100;
            double maxRange = 2;

            // player slowly regenerates while near the fireplace

            @Override
            public void handle(long now) {
                time++;
                if(time >= rotationLength){
                    time=0;
                    double x = CaveExplorer.getPlayerCharacter().getTileX() - thisTile.x;
                    double y = CaveExplorer.getPlayerCharacter().getTileY() - thisTile.y;
                    if(Math.abs(x) <= maxRange && Math.abs(y) <= maxRange){
                        CaveExplorer.getPlayerCharacter().healDamage(1);
                    }
                }
            }
        };
    }



    public Tile_Const_Fireplace(){
        super();
        setMovementBlocking(true);
        setBreakable(true);
        setReplaceable(false);
        setDurability(5);
    }
}