package com.company.Agent.Monster.MonsterAI;

import com.company.Agent.Agent;
import com.company.Agent.Monster.Monster;
import com.company.CaveExplorer;

public class SimpleFollowerAI extends MonsterAI{

    @Override
    public void handle(long now) {

        double x = monster.getTileX() - CaveExplorer.getPlayerCharacter().getTileX();
        double y = monster.getTileY() - CaveExplorer.getPlayerCharacter().getTileY();

        if(Math.sqrt(x*x+y*y)>searchRange){
            return;
        }

        Agent.MOVE_DIR primaryMoveDir;
        Agent.MOVE_DIR secondaryMoveDir;

        if(Math.abs(x)>Math.abs(y)){
            if(x > 0){
                primaryMoveDir = Agent.MOVE_DIR.LEFT;
            } else {
                primaryMoveDir = Agent.MOVE_DIR.RIGHT;
            }
            if(y > 0){
                secondaryMoveDir = Agent.MOVE_DIR.UP;
            } else {
                secondaryMoveDir = Agent.MOVE_DIR.DOWN;
            }
        } else {
            if(y > 0){
                primaryMoveDir = Agent.MOVE_DIR.UP;
            } else {
                primaryMoveDir = Agent.MOVE_DIR.DOWN;
            }
            if(x > 0){
                secondaryMoveDir = Agent.MOVE_DIR.LEFT;
            } else {
                secondaryMoveDir = Agent.MOVE_DIR.RIGHT;
            }
        }

        monster.walk(secondaryMoveDir);
        monster.walk(primaryMoveDir);
        // might be moved somewhere else
        monster.toFront();
    }

    public SimpleFollowerAI(Monster monster, int searchRange){
        super(monster, searchRange);
    }
}
