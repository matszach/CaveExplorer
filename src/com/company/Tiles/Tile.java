package com.company.Tiles;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.Scenes.MainGameScene;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

abstract public class Tile extends ImageView {

    // The tile's position (in tiles
    public int x;
    public int y;

    // does the tile block players movement?
    private boolean movementBlocking;
    public void setMovementBlocking(boolean movementBlocking) {
        this.movementBlocking = movementBlocking;
    }
    public boolean isMovementBlocking() {
        return movementBlocking;
    }

    // is is breakable
    private boolean breakable;
    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }
    public boolean isBreakable() {
        return breakable;
    }

    // can a block be placed over it ?
    private boolean replaceable;
    public void setReplaceable(boolean replaceable) {
        this.replaceable = replaceable;
    }
    public boolean isReplaceable() {
        return replaceable;
    }

    // how durable is this tile, unnecessary when not breakable
    private double durability;
    private double maxDurability;
    public void setDurability(double durability) {
        this.durability = durability;
        this.maxDurability = durability;
    }
    public double getDurability() {
        return durability;
    }

    // tile damaged
    public void takeDamage(double amount){
        if(isBreakable()){
            durability -= amount;
            showDamageEffect();
            if(getDurability() <= 0){
                crumble();
            }
        }
    }

    // tile crumbles
    protected void crumble(){
        MainGameScene.getBoard().replaceTile(new Tile_Floor(), x, y);
        MainGameScene.getBoard().getChildren().remove(dmgEffect);
        if(this instanceof  IResourceDropping && playerNearby(2)){
            ((IResourceDropping)this).dropResource();
        }
    }


    // tile damaged effect
    private ImageView dmgEffect = new ImageView();
    private void showDamageEffect(){
        dmgEffect.setImage(ImageBank.getTileDamage());
        dmgEffect.setFitHeight(GameValues.getTileSideLength());
        dmgEffect.setFitWidth(GameValues.getTileSideLength());
        /*
         * the +1 in relocate() prevents the pixel-wide white gap appearing when a player is exactly in the center of a tile
         * (the same usage as in agent location method
         */
        dmgEffect.relocate(x*GameValues.getTileSideLength(),y*GameValues.getTileSideLength()+1);
        if(durability < 0.25*maxDurability){
            dmgEffect.setViewport(new Rectangle2D(2 + 3*33, 2, 30,30));
        } else if (durability < 0.5*maxDurability){
            dmgEffect.setViewport(new Rectangle2D(2 + 2*33, 2, 30,30));
        } else if (durability < 0.75*maxDurability){
            dmgEffect.setViewport(new Rectangle2D(2 + 1*33, 2, 30,30));
        } else if (durability < maxDurability){
            dmgEffect.setViewport(new Rectangle2D(2 + 0*33, 2, 30,30));
        }
        if(!MainGameScene.getBoard().getChildren().contains(dmgEffect)){
            MainGameScene.getBoard().getChildren().add(dmgEffect);
        }
    }


    // TODO - also might get reworked
    // methods for rewarding the player
    private boolean playerNearby(double distance){
        return
                Math.abs(CaveExplorer.getPlayerCharacter().getTileX() - x) < distance &&
                Math.abs(CaveExplorer.getPlayerCharacter().getTileY() - y) < distance;
    }


    // set viewport from tileset by row and column number
    public void setViewByRowAndCol(int col, int row){
        setViewport(new Rectangle2D(2 + col*33, 2 + row*33, 30,30));
    }

    abstract void buildBackGround();


    // methods used in A* path-finding
    public double getH(Tile targetTile){
        double xSq = (targetTile.x - x) * (targetTile.x - x);
        double ySq = (targetTile.y - y) * (targetTile.y - y);
        return Math.sqrt(xSq+ySq);
    }
    private double g;
    public void setG(double g) {
        this.g = g;
    }
    public double getG(){
        return g;
    }
    public double getF(Tile targetTile){
        return getH(targetTile) + getG();
    }
    private Tile parentTile;
    public boolean hasParent(){
        return parentTile != null;
    }
    public void setParentTile(Tile parentTile) {
        this.parentTile = parentTile;
    }
    public Tile getParentTile() {
        return parentTile;
    }

    public boolean isEqualTo(Tile anotherTile){
        return x == anotherTile.x && y == anotherTile.y;
    }

    public Tile(){
        setFitHeight(GameValues.getTileSideLength());
        setFitWidth(GameValues.getTileSideLength());
        buildBackGround();



    }


}
