package com.company.Agent.Monster;

import com.company.Agent.Monster.MonsterAI.SporeCarrierAI;
import com.company.Agent.Monster.MonsterAI.ZombieAI;
import com.company.ImageBank;

final public class SporeCarrier extends Monster{


    @Override
    public void buildDefaultAppearance() {
        setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(0,4);
    }

    @Override
    public void buildMeleeAttackAppearance(int i) {
        //setImage(ImageBank.getAgentTiles1());
        setViewByRowAndCol(1+i,4);
    }

    public SporeCarrier(){
        super(6, 0.02);
        setDefence(3);
        buildDefaultAppearance();
        setMonsterAI(new SporeCarrierAI(this, 6));
        awaken();
    }
}