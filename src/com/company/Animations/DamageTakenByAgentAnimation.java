package com.company.Animations;

import com.company.Agent.Agent;
import com.company.GameValues;
import com.company.Scenes.MainGameScene;
import javafx.animation.AnimationTimer;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DamageTakenByAgentAnimation extends HBox {


    // Text
    private Text text = new Text();
    private void buildText(int damageTaken){
        text.setStyle("-fx-font: 14 arial;");
        text.setFill(GameValues.HP_BAR_FRONT);
        text.setText(""+damageTaken);
    }


    // animation cycle
    private int animationLoop = 0;

    public void play(Agent agent){

        relocate(agent.getTileX()* GameValues.getTileSideLength()+15,
                agent.getTileY()*GameValues.getTileSideLength());
        MainGameScene.getBoard().getChildren().add(this);

        DamageTakenByAgentAnimation animationInstance = this;
        DropShadow dropShadow = new DropShadow(0,0,0,GameValues.HP_BAR_FRONT);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                agent.setEffect(dropShadow);

                // floating text
                if(animationLoop >= 25){
                    stop();
                    MainGameScene.getBoard().getChildren().remove(animationInstance);
                } else {
                    relocate(agent.getTileX()*GameValues.getTileSideLength()+10,
                            agent.getTileY()*GameValues.getTileSideLength()-animationLoop);
                    animationLoop += 1;
                }

                // red flash
                if(animationLoop >= 25){
                    agent.setEffect(null);
                } else if(animationLoop >= 12){
                    dropShadow.setRadius(25-animationLoop);
                } else {
                    dropShadow.setRadius(animationLoop);
                }

            }
        };
        timer.start();
    }



    public DamageTakenByAgentAnimation(int damage){
        buildText(damage);
        setSpacing(2);
        getChildren().addAll(text);
    }
}
