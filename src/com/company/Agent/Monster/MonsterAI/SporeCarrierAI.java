package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Agent;
import com.company.Agent.Monster.Monster;
import com.company.CaveExplorer;
import com.company.Projectiles.DmgProjectile_SporeCarrier_Spores;
import com.company.Projectiles.Projectile;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;

public class SporeCarrierAI extends MonsterAI{

    private Agent.MOVE_DIR getDirToPlayer(){
        double x = monster.getTileX() - CaveExplorer.getPlayerCharacter().getTileX();
        double y = monster.getTileY() - CaveExplorer.getPlayerCharacter().getTileY();

        if(Math.abs(x/y) > 2 || Math.abs(x/y) < 0.5){
            if(Math.abs(x) > Math.abs(y)){
                if(x > 0){
                    return Agent.MOVE_DIR.LEFT;
                } else {
                    return Agent.MOVE_DIR.RIGHT;
                }
            } else {
                if(y > 0){
                    return Agent.MOVE_DIR.UP;
                } else {
                    return Agent.MOVE_DIR.DOWN;
                }
            }
        } else {
            if (x > 0) {
                if (y > 0) {
                    return Agent.MOVE_DIR.LEFT_UP;
                } else {
                    return Agent.MOVE_DIR.LEFT_DOWN;
                }
            } else {
                if (y > 0) {
                    return Agent.MOVE_DIR.RIGHT_UP;
                } else {
                    return Agent.MOVE_DIR.RIGHT_DOWN;
                }
            }
        }
    }

    @Override
    public void handle(long now) {

        // distance between the monster and a player
        double x = monster.getTileX() - CaveExplorer.getPlayerCharacter().getTileX();
        double y = monster.getTileY() - CaveExplorer.getPlayerCharacter().getTileY();

        // monster doesn't act if the player goes out of the search range
        if(Math.sqrt(x*x+y*y)>searchRange){
            return;
        }

        // walking in the direction of the player in a ~straight line
        //walkInDirectLine(x,y);
        Tile targetTile = MainGameScene.getBoard().getTiles()[CaveExplorer.getPlayerCharacter().roundTileX()][CaveExplorer.getPlayerCharacter().roundTileY()];
        findPathWithAStarAndWalk(targetTile);

        // monster tries to attack if the player is in range
        monster.attemptAttack();

        // monster fires a projectile at 0.5% chance
        if(Math.random() <= 0.005){
            Projectile spores = new DmgProjectile_SporeCarrier_Spores(5);
            spores.initiateTravel(monster, getDirToPlayer());
        }

        // might be moved somewhere else
        monster.toFront();

    }

    public SporeCarrierAI(Monster monster, int searchRange){
        super(monster, searchRange);
    }
}
