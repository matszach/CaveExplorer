package com.company.Projectiles;

import com.company.Agent.Agent;
import com.company.Agent.Monster.Monster;
import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.HUD.GameOverWindow;
import com.company.MonsterSpawnerAndHandler;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class Projectile extends ImageView {

    // unchangeable direction
    private final Agent.MOVE_DIR PROJECTILE_DIR;

    // projectile's speed in tiles/animation
    private double travelSpeed;

    // projectile's max range in tiles
    private double maxTravelDistance;
    private double distanceTraveled = 0;

    // movement methods
    private void move(double tileX, double tileY){
        relocate(getLayoutX() + tileX* GameValues.getTileSideLength(), getLayoutY() + tileY*GameValues.getTileSideLength());
        distanceTraveled += Math.sqrt(tileX*tileX + tileY*tileY);
    }

    // max distance reached
    private boolean maxTravelDistanceReached(){
        return maxTravelDistance <= distanceTraveled;
    }

    // gets rounded tile num of the projectile (to decide collision)
    public int roundTileX(){
        int fullTiles = (int)(getLayoutX()/GameValues.getTileSideLength());
        fullTiles += getLayoutX()/GameValues.getTileSideLength() - fullTiles >= 0.5 ? 1 : 0;
        return fullTiles;
    }
    public int roundTileY(){
        int fullTiles = (int)(getLayoutY()/GameValues.getTileSideLength());
        fullTiles += getLayoutY()/GameValues.getTileSideLength() - fullTiles >= 0.5 ? 1 : 0;
        return fullTiles;
    }

    // collision with a tile detected
    protected boolean ignoresTiles;
    private boolean collisionWithTileDetected(){
        if(MainGameScene.getBoard().getTiles()[roundTileX()][roundTileY()] == null){
            return false;
        } else {
            return !MainGameScene.getBoard().getTiles()[roundTileX()][roundTileY()].isReplaceable(); // todo water, lava and floor are replaceable -> this might be altered later
        }
    }
    private Tile getCollidingTile(){
        return MainGameScene.getBoard().getTiles()[roundTileX()][roundTileY()];
    }

    // collision with an agent detected
    protected boolean ignoresPlayer;
    protected boolean ignoresMonsters;
    private Agent originAgent = null;
    private boolean collisionWithAgentDetected(){
        if(!ignoresMonsters){
            for(Monster monster : MonsterSpawnerAndHandler.getActiveMonsters()){
                if(roundTileY() == monster.roundTileY() && roundTileX() == monster.roundTileX()){
                    tempAgent = monster;
                    return true;
                }
            }
        }
        if(!ignoresPlayer){
            if(roundTileY() == CaveExplorer.getPlayerCharacter().roundTileY() && roundTileX() == CaveExplorer.getPlayerCharacter().roundTileX()){
                tempAgent = CaveExplorer.getPlayerCharacter();
                return true;
            }
        }
        return false;
    }
    private Agent tempAgent;
    private Agent getCollidingAgent(){
        return tempAgent;
    }


    private void travel(Agent.MOVE_DIR move_dir){

        switch (move_dir){
            case LEFT: move(-travelSpeed, 0); break;
            case LEFT_UP: move(-0.75*travelSpeed, -0.75*travelSpeed); break;
            case UP: move(0, -travelSpeed); break;
            case RIGHT_UP: move(0.75*travelSpeed, -0.75*travelSpeed); break;
            case RIGHT: move(travelSpeed,0); break;
            case RIGHT_DOWN: move(0.75*travelSpeed, 0.75*travelSpeed); break;
            case DOWN: move(0,travelSpeed); break;
            case LEFT_DOWN: move(-0.75*travelSpeed, 0.75*travelSpeed); break;
            default:
        }

    }

    private int animRotation = 0;
    protected int[] animRotationIncrement = new int[]{10,20,30}; // default values that can be overridden
    private AnimationTimer projectileTravel = new AnimationTimer() {
        @Override
        public void handle(long now) {

            // effect
            if(maxTravelDistanceReached()){
                maxTravelDistanceReachedEffect();
            }
            if (collisionWithAgentDetected()){
                collisionWithAgentEffect(getCollidingAgent());
            }
            if (collisionWithTileDetected()){
                collisionWithTileEffect(getCollidingTile());
            }

            // travel (if not finalized)
            travel(PROJECTILE_DIR);


            // appearance
            if(animRotation <= animRotationIncrement[0]){
                setViewport(viewport1);
            } else if (animRotation <= animRotationIncrement[1]){
                setViewport(viewport2);
            } else if (animRotation <= animRotationIncrement[2]){
                setViewport(viewport3);
                if(animRotation == animRotationIncrement[2]){
                    animRotation = 0;
                }
            }

            animRotation++;


        }
    };


    public void initiateTravel(Agent origin){
        double x = GameValues.getTileSideLength()*(origin.getTileX()+0.5)-getFitWidth()/2;
        double y = GameValues.getTileSideLength()*(origin.getTileY()+0.5)-getFitHeight()/2;
        relocate(x,y);
        MainGameScene.getBoard().getChildren().add(this);
        projectileTravel.start();
    }

    protected void finalizeTravel(){
        projectileTravel.stop();
        MainGameScene.getBoard().getChildren().remove(this);
    }



    // projectile's appearance
    protected Rectangle2D viewport1;
    protected Rectangle2D viewport2;
    protected Rectangle2D viewport3;
    protected Rectangle2D buildViewportByGrid(int row, int col){
        return new Rectangle2D(2 + col*17,2 + row*17, 14,14);
    }
    abstract void setProjectileAppearance();

    // projectile's effect on collision with an agent
    abstract void collisionWithAgentEffect(Agent agent);

    // projectile's effect on collision with a non traversable tile
    abstract void collisionWithTileEffect(Tile tile);

    // projectile's effect upon reaching its ma range
    abstract void maxTravelDistanceReachedEffect();


    // constructor
    public Projectile(Agent.MOVE_DIR move_dir, double travelSpeed, double maxTravelDistance){
        PROJECTILE_DIR = move_dir;
        this.travelSpeed = travelSpeed;
        this.maxTravelDistance = maxTravelDistance;
        setProjectileAppearance();
    }
}
