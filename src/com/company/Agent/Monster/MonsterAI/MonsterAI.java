package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Agent;
import com.company.Agent.Monster.Monster;

import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;
import javafx.animation.AnimationTimer;
import javafx.scene.effect.ColorAdjust;


import java.util.ArrayList;

abstract public class MonsterAI extends AnimationTimer {

    // references the monster, needed for handle method
    Monster monster;

    // how close does the player have to be to the monster for it to start to pursue him/her
    int searchRange;

    // monster steps towards the player in a more or less straight line, stopping at any obstacles
    public void walkInDirectLine(double dirX, double dirY){

        // walking in the direction of the player in a ~straight line
        Agent.MOVE_DIR primaryMoveDir;
        Agent.MOVE_DIR secondaryMoveDir;

        if(Math.abs(dirX)>Math.abs(dirY)){
            if(dirX > 0){
                primaryMoveDir = Agent.MOVE_DIR.LEFT;
            } else {
                primaryMoveDir = Agent.MOVE_DIR.RIGHT;
            }
            if(dirY > 0){
                secondaryMoveDir = Agent.MOVE_DIR.UP;
            } else {
                secondaryMoveDir = Agent.MOVE_DIR.DOWN;
            }
        } else {
            if(dirY > 0){
                primaryMoveDir = Agent.MOVE_DIR.UP;
            } else {
                primaryMoveDir = Agent.MOVE_DIR.DOWN;
            }
            if(dirX > 0){
                secondaryMoveDir = Agent.MOVE_DIR.LEFT;
            } else {
                secondaryMoveDir = Agent.MOVE_DIR.RIGHT;
            }
        }

        // walking in primary direction second ensures that the monster is facing the direction closest to the player
        monster.walk(secondaryMoveDir);
        monster.walk(primaryMoveDir);
    }

    // monster walks to the player using the shortest available path, avoiding obstacles (A* algorithm)
    private ArrayList<Tile> openTiles = new ArrayList<>();
    private ArrayList<Tile> closedTiles = new ArrayList<>();
    private boolean noOpenTilesLeft(){
        return openTiles.size() == 0;
    }
    private Tile getOpenTileWithLowestFValue(Tile targetTile){

        Tile tileWithLowestFCost = null;

        for(Tile t : openTiles){
            if(tileWithLowestFCost == null){
                tileWithLowestFCost = t;
            } else {
                if(t.getF(targetTile) < tileWithLowestFCost.getF(targetTile)){
                    tileWithLowestFCost = t;
                }
            }
        }

        return tileWithLowestFCost;
    }
    private ArrayList<Tile> getLegalNeighbourTiles(Tile centerTile){

        ArrayList<Tile> tempNeighbours = new ArrayList<>();

        //    x - 1 / y - 1
        Tile tempTile1 = MainGameScene.getBoard().getTiles()[centerTile.x-1][centerTile.y-1];
        if(tempTile1 != null && !tempTile1.isMovementBlocking()){
            // since this is a corner neighbour, adjacent tiles need to be checked
            if(!MainGameScene.getBoard().getTiles()[centerTile.x-1][centerTile.y].isMovementBlocking() ||
               !MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y-1].isMovementBlocking()){
                tempNeighbours.add(tempTile1);
            }
        }

        //    x / y - 1
        Tile tempTile2 = MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y-1];
        if(tempTile2 != null && !tempTile2.isMovementBlocking()){
            tempNeighbours.add(tempTile2);
        }

        //    x + 1 / y - 1
        Tile tempTile3 = MainGameScene.getBoard().getTiles()[centerTile.x+1][centerTile.y-1];
        if(tempTile3 != null && !tempTile3.isMovementBlocking()){
            // since this is a corner neighbour, adjacent tiles need to be checked
            if(!MainGameScene.getBoard().getTiles()[centerTile.x+1][centerTile.y].isMovementBlocking() ||
               !MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y-1].isMovementBlocking()){
                tempNeighbours.add(tempTile3);
            }
        }

        //    x - 1 / y
        Tile tempTile4 = MainGameScene.getBoard().getTiles()[centerTile.x-1][centerTile.y];
        if(tempTile4 != null && !tempTile4.isMovementBlocking()){
            tempNeighbours.add(tempTile4);
        }

        //    x + 1 / y
        Tile tempTile5 = MainGameScene.getBoard().getTiles()[centerTile.x+1][centerTile.y];
        if(tempTile5 != null && !tempTile5.isMovementBlocking()){
            tempNeighbours.add(tempTile5);
        }

        //    x - 1 / y + 1
        Tile tempTile6 = MainGameScene.getBoard().getTiles()[centerTile.x-1][centerTile.y+1];
        if(tempTile6 != null && !tempTile6.isMovementBlocking()){
            // since this is a corner neighbour, adjacent tiles need to be checked
            if(!MainGameScene.getBoard().getTiles()[centerTile.x-1][centerTile.y].isMovementBlocking() ||
               !MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y+1].isMovementBlocking()){
                tempNeighbours.add(tempTile6);
            }
        }

        //    x / y + 1
        Tile tempTile7 = MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y+1];
        if(tempTile7 != null && !tempTile7.isMovementBlocking()){
            tempNeighbours.add(tempTile7);
        }

        //    x + 1 / y + 1
        Tile tempTile8 = MainGameScene.getBoard().getTiles()[centerTile.x+1][centerTile.y+1];
        if(tempTile8 != null && !tempTile8.isMovementBlocking()){
            // since this is a corner neighbour, adjacent tiles need to be checked
            if(!MainGameScene.getBoard().getTiles()[centerTile.x+1][centerTile.y].isMovementBlocking() ||
               !MainGameScene.getBoard().getTiles()[centerTile.x][centerTile.y+1].isMovementBlocking()){
                tempNeighbours.add(tempTile8);
            }
        }


        return tempNeighbours;
    }
    private Tile getDirectionTile(Tile targetTile, Tile startingTile){

        Tile directionTile = targetTile;

        while (directionTile.hasParent()){
            if(directionTile.getParentTile().isEqualTo(startingTile)){
                break;
            }
            directionTile = directionTile.getParentTile();
        }

        return directionTile;

    }
    private void walkTowardsTile(Tile directionTile){

        double dirX = monster.getTileX() - directionTile.x;
        double dirY = monster.getTileY() - directionTile.y;

        if(dirX < 0){
            monster.walk(Agent.MOVE_DIR.RIGHT);
        } else if (dirX > 0){
            monster.walk(Agent.MOVE_DIR.LEFT);
        }

        if(dirY < 0){
            monster.walk(Agent.MOVE_DIR.DOWN);
        } else if (dirY > 0){
            monster.walk(Agent.MOVE_DIR.UP);
        }

    }
    private void finalizePathfinding(){
        for(Tile tile : openTiles){
            tile.setG(0);
            tile.setParentTile(null);
        }
        openTiles.clear();
        for(Tile tile : closedTiles){
            tile.setG(0);
            tile.setParentTile(null);
        }
        closedTiles.clear();
    }
    public void findPathWithAStarAndWalk(Tile targetTile){

        // starting tile
        Tile startingTile = MainGameScene.getBoard().getTiles()[monster.roundTileX()][monster.roundTileY()];
        startingTile.setG(0);
        startingTile.setParentTile(null);
        openTiles.add(startingTile);


        // pathfinding loop
        while (!noOpenTilesLeft()){

            Tile currentTile = getOpenTileWithLowestFValue(targetTile);
            openTiles.remove(currentTile);
            closedTiles.add(currentTile);
            // currentTile.setEffect(new ColorAdjust(0.2,0.5,0.5,0.5)); <- artifact used for closed tile coloring

            if(currentTile.isEqualTo(targetTile)){
                walkTowardsTile(getDirectionTile(targetTile, startingTile));
                break;
            }

            for(Tile neighbour : getLegalNeighbourTiles(currentTile)){

                if(closedTiles.contains(neighbour)){
                    continue;
                }

                double x = currentTile.x - neighbour.x;
                double y = currentTile.y - neighbour.y;
                double addedGCost = Math.sqrt(x*x+y*y);
                if(!openTiles.contains(neighbour) || neighbour.getF(targetTile) > currentTile.getF(targetTile)+addedGCost){
                    neighbour.setG(addedGCost);
                    neighbour.setParentTile(currentTile);
                    if(!openTiles.contains(neighbour)){
                        openTiles.add(neighbour);
                    }
                }

            }

        }





        // closing the method
        finalizePathfinding();

    }


    public MonsterAI(Monster monster, int searchRange){
        this.monster = monster;
        this.searchRange = searchRange;
    }
}
