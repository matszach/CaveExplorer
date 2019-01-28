package com.company;

import com.company.Agent.Monster.Zombie;
import com.company.Scenes.MainGameScene;

public class MonsterSpawner {

    private MonsterSpawner instance = new MonsterSpawner();

    private static final double MAX_DISTANCE_TO_PLAYER = 7;


    public static void spawnAttepmt(int tileX, int tileY){

        // TODO very wip
        if(Math.random() > 0.97 &&
           !MainGameScene.getBoard().getTiles()[tileX][tileY].isMovementBlocking() &&
           Math.abs(CaveExplorer.getPlayerCharacter().getTileX() - tileX) > MAX_DISTANCE_TO_PLAYER &&
           Math.abs(CaveExplorer.getPlayerCharacter().getTileY() - tileY) > MAX_DISTANCE_TO_PLAYER) {

            Zombie zombie = new Zombie();
            zombie.relocate(GameValues.getTileSideLength()*tileX,GameValues.getTileSideLength()*tileY+1);
            MainGameScene.getBoard().getChildren().add(zombie);
        }

    }









    private MonsterSpawner(){

    }

}
