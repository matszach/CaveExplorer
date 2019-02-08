package com.company;

import com.company.Agent.Monster.ArmoredZombie;
import com.company.Agent.Monster.Monster;
import com.company.Agent.Monster.MonsterAI.EnragedZombie;
import com.company.Agent.Monster.Zombie;
import com.company.Scenes.MainGameScene;

import java.util.ArrayList;
import java.util.Iterator;


final public class MonsterSpawnerAndHandler {

    private MonsterSpawnerAndHandler instance = new MonsterSpawnerAndHandler();

    // Currently active monsters
    private static ArrayList<Monster> activeMonsters = new ArrayList<>();

    public static ArrayList<Monster> getActiveMonsters() {
        return activeMonsters;
    }

    // despawns monsters that are to far from the player
    public static void despawnDistantMonsters(){
        Iterator<Monster> iterator = activeMonsters.iterator();
        while (iterator.hasNext()){
            Monster monster = iterator.next();
            if( Math.abs(CaveExplorer.getPlayerCharacter().getTileX() - monster.getTileX()) > MIN_DISTANCE_TO_DESPAWN ||
                Math.abs(CaveExplorer.getPlayerCharacter().getTileY() - monster.getTileY()) > MIN_DISTANCE_TO_DESPAWN){
                monster.despawn();
                iterator.remove();
            }
            if( !monster.isAlive()){
                monster.despawn();
                iterator.remove();
            }
        }
    }
    // max amount of monsters spawned at once
    private static final int MAX_MONSTER_AMOUNT = 8;

    // max distance in tiles for a monster to spawn (this prevents monsters spawning in player's visible range)
    private static final double MAX_DISTANCE_TO_PLAYER = 8;

    // max distance in tiles for a monster to spawn (this prevents monsters spawning in player's visible range)
    private static final double MIN_DISTANCE_TO_DESPAWN = 25;

    // monster spawn chance (the chance that the monster will spawn if a suitable tile is drawn)
    private static final double MONSTER_SPAWN_CHANCE = 0.06;


    public static void spawnAttempt(int tileX, int tileY){

        // TODO very wip
        if(Math.random() < MONSTER_SPAWN_CHANCE &&
           activeMonsters.size() < MAX_MONSTER_AMOUNT &&
           !MainGameScene.getBoard().getTiles()[tileX][tileY].isMovementBlocking() &&
           Math.abs(CaveExplorer.getPlayerCharacter().getTileX() - tileX) > MAX_DISTANCE_TO_PLAYER &&
           Math.abs(CaveExplorer.getPlayerCharacter().getTileY() - tileY) > MAX_DISTANCE_TO_PLAYER) {

                Monster monster;

                double monsterRoll = Math.random();

                if(monsterRoll > 0.4){
                    monster = new Zombie();
                } else if (monsterRoll > 0.2){
                    monster = new ArmoredZombie();
                } else {
                    monster = new EnragedZombie();
                }

                monster.relocate(GameValues.getTileSideLength()*tileX,GameValues.getTileSideLength()*tileY+1);
                MainGameScene.getBoard().getChildren().add(monster);

                activeMonsters.add(monster);
        }

    }


    public static void despawnAll(){
        for(Monster monster : getActiveMonsters()){
           monster.despawn();
        }
        getActiveMonsters().clear();
    }







    private MonsterSpawnerAndHandler(){

    }

}
