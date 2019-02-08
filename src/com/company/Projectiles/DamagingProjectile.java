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



    public DamagingProjectile(double travelSpeed, double maxTravelDistance, double averageDamage){
        super(travelSpeed, maxTravelDistance);
        this.averageDamage = averageDamage;
    }
}
