package com.company.Agent.Monster;

import com.company.Agent.Monster.MonsterAI.ZombieAI;
import com.company.ImageBank;

final public class Zombie extends Monster{


    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,1);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        //setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(1+i,1);
    }

    public Zombie(){
        super(5, 0.02);
        buildDefaultAppearance();
        setMonsterAI(new ZombieAI(this, 8));
        awaken();
    }
}
