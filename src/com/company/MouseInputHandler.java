package com.company;

import com.company.Agent.Agent;
import com.company.Agent.PlayerCharacter.PlayerInventory;
import com.company.CaveExplorer;
import com.company.HUD.ActionChoiceBox;
import com.company.HUD.ActionOptionPane;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public final class MouseInputHandler {

    // player is drilling
    private static boolean drilling;
    private static int drillingPhase = 0;
    private static final int DRILL_PHASES[] = new int[]{2,4,6,8};

    private static void rotatePlayer(MouseEvent e){
        double xDirection = e.getSceneX() - CaveExplorer.getMainGameScene().getWidth()/2;
        double yDirection = e.getSceneY() - CaveExplorer.getMainGameScene().getHeight()/2;


        if(Math.abs(xDirection/yDirection) > 2 || Math.abs(xDirection/yDirection) < 0.5){
            if(Math.abs(xDirection) > Math.abs(yDirection)){
                if(e.getSceneX() > CaveExplorer.getMainGameScene().getWidth()/2){
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.RIGHT);
                } else {
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.LEFT);
                }
            } else {
                if(e.getSceneY() > CaveExplorer.getMainGameScene().getHeight()/2){
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.DOWN);
                } else {
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.UP);
                }
            }
        } else {
            if(xDirection > 0){
                if(yDirection > 0){
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.RIGHT_DOWN);
                } else {
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.RIGHT_UP);
                }
            } else {
                if(yDirection > 0){
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.LEFT_DOWN);
                } else {
                    CaveExplorer.getPlayerCharacter().face(Agent.MOVE_DIR.LEFT_UP);
                }
            }
        }



    }


    private static AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {

            if (drilling){
                if(drillingPhase <= DRILL_PHASES[0]){
                    CaveExplorer.getPlayerCharacter().buildDrillingAppearance(0);
                    drillingPhase++;
                } else if(drillingPhase <= DRILL_PHASES[1]){
                    CaveExplorer.getPlayerCharacter().buildDrillingAppearance(1);
                    drillingPhase++;
                } else if(drillingPhase <= DRILL_PHASES[2]) {
                    CaveExplorer.getPlayerCharacter().buildDrillingAppearance(2);
                    drillingPhase++;
                } else if(drillingPhase <= DRILL_PHASES[3]){
                    CaveExplorer.getPlayerCharacter().buildDrillingAppearance(1);
                    drillingPhase++;
                    if(drillingPhase > DRILL_PHASES[3]){
                        drillingPhase = 0;
                        CaveExplorer.getPlayerCharacter().damageTile();
                    }
                }
            } else {
                CaveExplorer.getPlayerCharacter().buildDefaultAppearance();
            }
        }
    };

    public static void start(){
        timer.start();
    }

    public static void stop(){
        timer.stop();
    }

    public static void reset(){
        drilling = false;
    }

    public MouseInputHandler(Stage primaryStage){

        primaryStage.getScene().setOnMousePressed(e->{
            if(!KeyInputHandler.blockInputEvents()) {
                drilling = true;
            }
        });
        primaryStage.getScene().setOnMouseReleased(e->{
            if(!KeyInputHandler.blockInputEvents()){
                drilling = false;
            }
        });
        primaryStage.getScene().setOnMouseMoved(e->{
            if(!KeyInputHandler.blockInputEvents()){
                rotatePlayer(e);
            }
        });
        primaryStage.getScene().setOnMouseDragged(e->{
            if(!KeyInputHandler.blockInputEvents()){
                rotatePlayer(e);
            }
        });
        primaryStage.getScene().setOnScroll(e->{
            if(!KeyInputHandler.blockInputEvents()){
                if(e.getDeltaY() > 0){
                    ActionChoiceBox.moveSelectionDown();
                } else {
                    ActionChoiceBox.moveSelectionUp();
                }
            }
        });
    }
}
