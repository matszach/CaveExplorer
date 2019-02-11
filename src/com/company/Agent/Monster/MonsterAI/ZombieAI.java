package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Monster.Monster;
import com.company.CaveExplorer;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;

final public class ZombieAI extends MonsterAI{

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

        // might be moved somewhere else
        monster.toFront();

    }

    public ZombieAI(Monster monster, int searchRange){
        super(monster, searchRange);
    }
}
