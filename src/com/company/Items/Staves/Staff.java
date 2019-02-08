package com.company.Items.Staves;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.CaveExplorer;
import com.company.Items.IUsableOnButtonPressed;
import com.company.Items.Item;
import com.company.Projectiles.DamagingProjectile;
import com.company.Projectiles.Projectile;
import javafx.animation.AnimationTimer;


abstract public class Staff extends Item implements IUsableOnButtonPressed {

    private double averageDamage;
    private Class<? extends DamagingProjectile> projectileClass;

    private void launchProjectile(){
        try {
            Projectile projectile = projectileClass.getDeclaredConstructor(double.class).newInstance(averageDamage);
            projectile.initiateTravel(CaveExplorer.getPlayerCharacter(), CaveExplorer.getPlayerCharacter().getDirFacing());
        } catch (Exception e){

        }
    }

    // prevents staring another attack when the first one is in motion
    private boolean castingInProgress = false;


    @Override
    public void usage(PlayerCharacter playerCharacter) {

        castingInProgress = true;

        AnimationTimer attack = new AnimationTimer() {

            int USE_PHASES[] = new int[]{15,45,75};
            int animationTime = 0;


            @Override
            public void handle(long now) {

                playerCharacter.setLongViewSize();

                castingInProgress = true;

                if(animationTime <= USE_PHASES[0]){
                    playerCharacter.buildStaffCastAppearance(0);
                    // projectile is launched in the earlier stages of the attack
                    if(animationTime == USE_PHASES[0]){
                        launchProjectile();
                    }

                } else if(animationTime <= USE_PHASES[1]){
                    playerCharacter.buildStaffCastAppearance(1);

                } else if(animationTime <= USE_PHASES[2]) {

                    playerCharacter.buildStaffCastAppearance(2);

                    if(animationTime == USE_PHASES[2]){
                        playerCharacter.setDefaultViewSize();
                        playerCharacter.buildDefaultAppearance();
                        animationTime = 0;
                        castingInProgress = false;
                        stop();
                    }
                }

                animationTime++;
            }
        };
        attack.start();
    }

    @Override
    public boolean usageInProgress() {
        return castingInProgress;
    }

    public Staff(Class<? extends DamagingProjectile> projectileClass, double averageDamage){
        this.projectileClass = projectileClass;
        this.averageDamage = averageDamage;
    }


}
