package com.company.Agent.Monster;

import com.company.Agent.Agent;
import com.company.Agent.Monster.MonsterAI.MonsterAI;
import javafx.collections.ObservableList;
import javafx.scene.Node;

abstract public class Monster extends Agent {

    @Override
    public void walk(MOVE_DIR move_dir) {
        face(move_dir);
        super.walk(move_dir);
    }

    // Monster Ai decides the behaviour style of the monster
    private MonsterAI monsterAI;
    public void setMonsterAI(MonsterAI monsterAI) {
        this.monsterAI = monsterAI;
    }
    public MonsterAI getMonsterAI() {
        return monsterAI;
    }

    // The monster begins taking actions
    public void awaken(){
        getMonsterAI().start();
    }
}