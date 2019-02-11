package com.company.Agent.Monster;

import com.company.Agent.Monster.MonsterAI.ZombieAI;
import com.company.ImageBank;

final public class ArmoredZombie extends Monster{


    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,2);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        //setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(1+i,2);
    }

    public ArmoredZombie(){
        super(8, 0.02);
        setDefence(5);
        buildDefaultAppearance();
        setMonsterAI(new ZombieAI(this, 8));
        awaken();
    }
}