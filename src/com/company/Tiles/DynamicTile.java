package com.company.Tiles;

import javafx.animation.AnimationTimer;

abstract public class DynamicTile extends Tile{

    protected AnimationTimer changes;
    public AnimationTimer getChanges() {
        return changes;
    }
    abstract protected void setChanges();

    @Override
    protected void crumble() {
        super.crumble();
        changes.stop();
    }

    public DynamicTile(){
        super();
        setChanges();
        changes.start();

    }
}
