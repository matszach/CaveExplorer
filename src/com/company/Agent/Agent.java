package com.company.Agent;

import com.company.Agent.Monster.Monster;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Animations.DamageTakenByAgentAnimation;
import com.company.Animations.HealthRestoredToAgentAnimation;
import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.MonsterSpawnerAndHandler;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

abstract public class Agent extends ImageView {


    // Health and damage
    public static final double MAX_HEALTH = 100;

    private double currentHealth = MAX_HEALTH;
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }
    public double getCurrentHealth() {
        return currentHealth;
    }

    public void takeDamage(double damage){

        damage = damage > defence ? damage - defence : 0;
        currentHealth -= damage;

        DamageTakenByAgentAnimation animation = new DamageTakenByAgentAnimation((int)damage);
        animation.play(this);

        if(currentHealth < 0){
            currentHealth = 0;
        }

    }
    public void healDamage(double healing){

        HealthRestoredToAgentAnimation animation = new HealthRestoredToAgentAnimation((int)healing);
        animation.play(this);

        currentHealth += healing;
        if(currentHealth > MAX_HEALTH){
            currentHealth = MAX_HEALTH;
        }
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }

    private double defence = 0;
    public double getDefence() {
        return defence;
    }
    public void setDefence(double defence) {
        this.defence = defence;
    }



    // Used for direction stating
    public enum MOVE_DIR { LEFT, LEFT_UP, UP, RIGHT_UP, RIGHT, RIGHT_DOWN, DOWN, LEFT_DOWN}

    // Direction the character currently is facing
    private MOVE_DIR dirFacing = MOVE_DIR.DOWN;
    public MOVE_DIR getDirFacing() {
        return dirFacing;
    }
    private void setDirFacing(MOVE_DIR dirFacing) {
        this.dirFacing = dirFacing;
    }

    // Movement methods
    private boolean movementBlockedByAnAgent(Agent agent, MOVE_DIR move_dir){

        double MAX_DIST = 0.75;

        if(this == agent){
            return false;
        }


        if(Math.abs(getTileX() - agent.getTileX()) >= 1 || Math.abs(getTileY() - agent.getTileY()) >= 1 ){
            return false;
        }


        switch (move_dir){
            case LEFT:
                if(getTileX() > agent.getTileX() && getTileX() - agent.getTileX() < MAX_DIST && Math.abs(getTileY() - agent.getTileY()) <  MAX_DIST-0.1 ){ // the "-0.1" allows movement sideways to the blocking agent
                    return true;
                }
                break;
            case DOWN:
                if(getTileY() < agent.getTileY() && agent.getTileY() - getTileY() <  MAX_DIST && Math.abs(getTileX() - agent.getTileX()) <  MAX_DIST-0.1){
                    return true;
                }
                break;
            case RIGHT:
                if(getTileX() < agent.getTileX() && agent.getTileX() - agent.getTileX() <  MAX_DIST && Math.abs(getTileY() - agent.getTileY()) <  MAX_DIST-0.1){
                    return true;
                }
                break;
            case UP:
                if(getTileY() > agent.getTileY() && getTileY() - agent.getTileY() <  MAX_DIST && Math.abs(getTileX() - agent.getTileX()) <  MAX_DIST-0.1){
                    return true;
                }
                break;
        }
        return false;

    }
    private boolean movementBlockedByAgents(MOVE_DIR move_dir){

        // checks collision against active monsters
        for(Monster monster : MonsterSpawnerAndHandler.getActiveMonsters()){
            if(movementBlockedByAnAgent(monster, move_dir)){
                return true;
            }
        }
        // if agent s a monster -> check collision against player (player doest check collision against itself)
        if(this instanceof Monster){
            return movementBlockedByAnAgent(CaveExplorer.getPlayerCharacter(), move_dir);
        }
        return false;
    }
    public boolean movePossibleInDirection(MOVE_DIR move_dir){

        if(movementBlockedByAgents(move_dir)){
            return false;
        }


        switch (move_dir){
            case LEFT:
                // blocks movement at th edge of the map
                if(roundUpTileX() <= 0){
                    return false;
                }
                // blocks movement if impassable block encountered
                if( MainGameScene.getBoard().getBoardTileTypes()[roundUpTileX()-1][roundDownTileY()] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundUpTileX()-1][roundDownTileY()].isMovementBlocking()){
                    return false;
                }
                if( MainGameScene.getBoard().getBoardTileTypes()[roundUpTileX()-1][roundUpTileY()] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundUpTileX()-1][roundUpTileY()].isMovementBlocking()){
                    return false;
                }
                return true;
            case DOWN:
                // blocks movement at th edge of the map
                if(roundDownTileY()+1 >= MainGameScene.getBoard().getBoardTileTypes()[0].length){
                    return false;
                }
                // blocks movement if impassable block encountered
                if( MainGameScene.getBoard().getBoardTileTypes()[roundDownTileX()][roundDownTileY()+1] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundDownTileX()][roundDownTileY()+1].isMovementBlocking()){
                    return false;
                }
                if( MainGameScene.getBoard().getBoardTileTypes()[roundUpTileX()][roundDownTileY()+1] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundUpTileX()][roundDownTileY()+1].isMovementBlocking()){
                    return false;
                }
                return true;
            case RIGHT:
                // blocks movement at th edge of the map
                if(roundDownTileX()+1 >= MainGameScene.getBoard().getBoardTileTypes().length){
                    return false;
                }
                // blocks movement if impassable block encountered
                if( MainGameScene.getBoard().getBoardTileTypes()[roundDownTileX()+1][roundDownTileY()] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundDownTileX()+1][roundDownTileY()].isMovementBlocking()){
                    return false;
                }
                if( MainGameScene.getBoard().getBoardTileTypes()[roundDownTileX()+1][roundUpTileY()] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundDownTileX()+1][roundUpTileY()].isMovementBlocking()){
                    return false;
                }
                return true;
            case UP:
                // blocks movement at th edge of the map
                if(roundUpTileY() <= 0){
                    return false;
                }
                // blocks movement if impassable block encountered
                if( MainGameScene.getBoard().getBoardTileTypes()[roundDownTileX()][roundUpTileY()-1] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundDownTileX()][roundUpTileY()-1].isMovementBlocking()){
                    return false;
                }
                if( MainGameScene.getBoard().getBoardTileTypes()[roundUpTileX()][roundUpTileY()-1] > 0 &&
                    MainGameScene.getBoard().getTiles()[roundUpTileX()][roundUpTileY()-1].isMovementBlocking()){
                    return false;
                }

            default: return true;
        }
    }
    public void move(double tileX, double tileY){
        relocate(getLayoutX() + tileX*GameValues.getTileSideLength(), getLayoutY() + tileY*GameValues.getTileSideLength());
    }
    public void face(MOVE_DIR move_dir){

        if(getDirFacing() != move_dir){

            getTransforms().clear();

            switch (getDirFacing()){
                case LEFT:
                    move(-1,0);
                    break;
                case LEFT_UP:
                    move(-1.2,-0.45);
                    break;
                case UP:
                    move(-1,-1);
                    break;
                case RIGHT_UP:
                    move(-0.45,-1.2);
                    break;
                case RIGHT:
                    move(0,-1);
                    break;
                case RIGHT_DOWN:
                    move(0.17,-0.45);
                    break;
                case DOWN:
                    break;
                case LEFT_DOWN:
                    move(-0.45,0.17);
                    break;
            }

            switch (move_dir){
                case LEFT:
                    getTransforms().add(new Rotate(90,Rotate.Z_AXIS));
                    move(1,0);
                    setDirFacing(move_dir);
                    break;
                case LEFT_UP:
                    getTransforms().add(new Rotate(135,Rotate.Z_AXIS));
                    move(1.2,0.45);
                    setDirFacing(move_dir);
                    break;
                case UP:
                    getTransforms().add(new Rotate(180,Rotate.Z_AXIS));
                    move(1,1);
                    setDirFacing(move_dir);
                    break;
                case RIGHT_UP:
                    getTransforms().add(new Rotate(225,Rotate.Z_AXIS));
                    move(0.45,1.2);
                    setDirFacing(move_dir);
                    break;
                case RIGHT:
                    getTransforms().add(new Rotate(270,Rotate.Z_AXIS));
                    move(0,1);
                    setDirFacing(move_dir);
                    break;
                case RIGHT_DOWN:
                    getTransforms().add(new Rotate(315,Rotate.Z_AXIS));
                    move(-0.17,0.45);
                    setDirFacing(move_dir);
                    break;
                case DOWN:
                    setDirFacing(move_dir);
                    break;
                case LEFT_DOWN:
                    getTransforms().add(new Rotate(45,Rotate.Z_AXIS));
                    move(0.45,-0.17);
                    setDirFacing(move_dir);
                    break;

            }
        }
    }
    public void walk(MOVE_DIR move_dir){
        if(movePossibleInDirection(move_dir)){
            if(this instanceof PlayerCharacter){
                CaveExplorer.moveView(move_dir);
            }
            switch (move_dir){
                case LEFT: move(-getMovementSpeed(), 0); break;
                case UP: move(0, -getMovementSpeed()); break;
                case RIGHT: move(getMovementSpeed(),0); break;
                case DOWN: move(0,getMovementSpeed()); break;
                default:
            }
        }
    }

    // Actions
    // Agent damages the tile in front of it
    public void damageTile(double dmg){
        int x = roundTileX();
        int y = roundTileY();
        switch (getDirFacing()){
            case LEFT: x--; break;
            case LEFT_UP:
                // prevents diagonal mining "through walls" -> a tile directly above
                // will be mined before the diagonal one
                if(!MainGameScene.getBoard().getTiles()[x][y-1].isMovementBlocking() ||
                   !MainGameScene.getBoard().getTiles()[x-1][y].isMovementBlocking()){
                    // if at least one tile (either up or left) is free to walk through -> then the diagonal tile will be mined
                    x--;
                }
                y--;
                break;
            case UP: y--; break;
            case RIGHT_UP:
                if(!MainGameScene.getBoard().getTiles()[x][y-1].isMovementBlocking() ||
                   !MainGameScene.getBoard().getTiles()[x+1][y].isMovementBlocking()){
                    y--;
                }
                x++;
                break;
            case RIGHT: x++; break;
            case RIGHT_DOWN:
                if(!MainGameScene.getBoard().getTiles()[x][y+1].isMovementBlocking() ||
                   !MainGameScene.getBoard().getTiles()[x+1][y].isMovementBlocking()){
                    x++;
                }
                y++;
                break;
            case DOWN: y++; break;
            case LEFT_DOWN:
                if(!MainGameScene.getBoard().getTiles()[x][y+1].isMovementBlocking() ||
                   !MainGameScene.getBoard().getTiles()[x-1][y].isMovementBlocking()){
                    y++;
                }
                x--;
                break;
        }
        if(x >= 0 && x <= MainGameScene.getBoard().getTiles().length-1 &&
           y >= 0 && y <= MainGameScene.getBoard().getTiles().length-1 &&
            MainGameScene.getBoard().getTiles()[x][y] != null ){
            // damages the tile, which, upon reaching 0> durability, will crumble
            MainGameScene.getBoard().getTiles()[x][y].takeDamage(dmg);
        }
    }

    // Agent places (and replaces) the tile in front of him
    // returns true if tile successfully placed
    public boolean buildTile(Tile tile){
        int x = roundTileX();
        int y = roundTileY();
        switch (getDirFacing()){
            case LEFT: x--; break;
            case LEFT_UP: x--; y--;  break;
            case UP: y--; break;
            case RIGHT_UP: x++; y--;  break;
            case RIGHT: x++; break;
            case RIGHT_DOWN: x++; y++;  break;
            case DOWN: y++; break;
            case LEFT_DOWN: x--; y++;  break;
        }
        if(x >= 0 && x <= MainGameScene.getBoard().getTiles().length-1 &&
           y >= 0 && y <= MainGameScene.getBoard().getTiles().length-1 &&
            MainGameScene.getBoard().getTiles()[x][y] != null &&
            MainGameScene.getBoard().getTiles()[x][y].isReplaceable()){
           // replaces the tile with a new one
            MainGameScene.getBoard().replaceTile(tile, x, y);
            return true;
        }
        return false;
    }

    // targeting a tile TODO
    private int animationTime = 0;
    public void targetTile(){

        int x = roundTileX();
        int y = roundTileY();
        switch (getDirFacing()){
            case LEFT: x--; break;
            case LEFT_UP: x--; y--;  break;
            case UP: y--; break;
            case RIGHT_UP: x++; y--;  break;
            case RIGHT: x++; break;
            case RIGHT_DOWN: x++; y++;  break;
            case DOWN: y++; break;
            case LEFT_DOWN: x--; y++;  break;
        }

        Tile tile = MainGameScene.getBoard().getTiles()[x][y];

        AnimationTimer highlighter = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(animationTime == 0){
                    tile.setOpacity(0.95);
                }else if(animationTime == 2){
                    tile.setOpacity(0.9);
                }else if(animationTime == 4){
                    tile.setOpacity(0.85);
                }else if(animationTime == 6){
                    tile.setOpacity(0.9);
                }else if(animationTime == 8){
                    tile.setOpacity(0.95);
                }else if(animationTime == 10){
                    tile.setOpacity(1);
                    animationTime=-1;
                    stop();
                }
                animationTime++;
            }
        };
        highlighter.start();

    }

    // Moving Agent's speed value in Tiles
    // SHOULD BE A DIVISOR OF 1 (so 0.1 or 0.01 etc, not 0.08 etc)
    private double movementSpeed;
    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
    public double getMovementSpeed() {
        return movementSpeed;
    }


    // Returns X and Y (of the center) of the Agent, in pixels or in Tiles
    public double getPositionX(){
        return getLayoutX() + GameValues.getTileSideLength()/2;
    }
    // FIXME: 2019-01-15 the "-1" os the to counteract the "+1" pixel at initial placement
    // FIXME -> it removes the weird white borders when the agent is placed EXACTLY in  the middle of a tile
    // FIXME -> the face methods will have to be fixed for the very same reason
    public double getPositionY(){
        return getLayoutY() + GameValues.getTileSideLength()/2-1;
    }

    public double getTileX(){
        switch (getDirFacing()){
            case LEFT : case UP:
                return getPositionX()/GameValues.getTileSideLength()-1.5;
            case LEFT_UP:
                return getPositionX()/GameValues.getTileSideLength()-1.7;
            case RIGHT_UP: case LEFT_DOWN:
                return getPositionX()/GameValues.getTileSideLength()-0.95;
            case RIGHT_DOWN:
                return getPositionX()/GameValues.getTileSideLength()-0.33;
            default:
                return getPositionX()/GameValues.getTileSideLength()-0.5;
        }
    }
    public double getTileY(){
        switch (getDirFacing()){
            case UP: case RIGHT:
                return getPositionY()/GameValues.getTileSideLength()-1.5;
            case LEFT_UP: case RIGHT_DOWN:
                return getPositionY()/GameValues.getTileSideLength()-0.95;
            case RIGHT_UP:
                return getPositionY()/GameValues.getTileSideLength()-1.7;
            case LEFT_DOWN:
                return getPositionY()/GameValues.getTileSideLength()-0.33;
            default:
                return getPositionY()/GameValues.getTileSideLength()-0.5;
        }
    }

    public int roundTileX(){
        int fullTiles = (int)getTileX();
        fullTiles += getTileX() - fullTiles >= 0.5 ? 1 : 0;
        return fullTiles;
    }
    public int roundTileY(){
        int fullTiles = (int)getTileY();
        fullTiles += getTileY() - fullTiles >= 0.5 ? 1 : 0;
        return fullTiles;
    }

    public int roundUpTileX(){
        int fullTiles = (int)getTileX();
        fullTiles += fullTiles < getTileX() ? 1 : 0;
        return fullTiles;
    }
    public int roundDownTileX(){
        return (int)(getTileX());
    }
    public int roundUpTileY(){
        int fullTiles = (int)getTileY();
        fullTiles += fullTiles < getTileY() ? 1 : 0;
        return fullTiles;
    }
    public int roundDownTileY(){
        return (int)getTileY();
    }

    // Builds the default appearance of the agent
    abstract public void buildDefaultAppearance();

    // Builds the appearance of the agent while performing a melee attack
    abstract public void buildMeleeAttackAppearance(int i);

    // set viewport from tileset by row and column number
    public void setViewByRowAndCol(int col, int row){
        setViewport(new Rectangle2D(2 + col*33, 2 + row*33, 30,30));
    }
    public void setLongViewByRowAndCol(int col, int row){
        setViewport(new Rectangle2D(2 + col*33, 2 + row*33, 30,61));
    }

    // set default view (1x1)
    public void setDefaultViewSize(){
        setFitHeight(GameValues.getTileSideLength());
        setFitWidth(GameValues.getTileSideLength());
    }

    // set long view (1x2) (still considered a 1x1 for hit-box purposes, but allows longer animation
    public void setLongViewSize(){
        setFitHeight(2*GameValues.getTileSideLength()+1);
        setFitWidth(GameValues.getTileSideLength());
    }
    public Agent(){
        setDefaultViewSize();
    }


}
