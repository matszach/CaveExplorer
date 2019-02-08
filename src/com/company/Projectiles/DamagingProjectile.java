package com.company.Projectiles;

import com.company.Agent.Agent;

abstract public class DamagingProjectile extends Projectile {

    protected double averageDamage;

    @Override
    void collisionWithAgentEffect(Agent agent) {
        agent.takeDamage(averageDamage/2 + Math.random()*averageDamage);
        finalizeTravel();
    }


    @Override
    void maxTravelDistanceReachedEffect() {
        finalizeTravel();
    }



    public DamagingProjectile(Agent.MOVE_DIR move_dir, double travelSpeed, double maxTravelDistance, double averageDamage){
        super(move_dir, travelSpeed, maxTravelDistance);
        this.averageDamage = averageDamage;
    }
}
