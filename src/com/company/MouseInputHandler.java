package com.company;

import com.company.Agent.Agent;
import com.company.HUD.ActionBar;
import com.company.Items.IUsable;
import com.company.Items.Item;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public final class MouseInputHandler {

    // player is useItem
    private static boolean useItem;
    private static int usePhase = 0;
    private static final int MAX_USE_PHASE = 8;

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

            if (useItem){

                // is active item is usable -> runs it through is usage animation (if any)
                Item activeItem = CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[ActionBar.getSelectedPaneNum()][5];
                if(activeItem instanceof IUsable){
                    ((IUsable) activeItem).usage(CaveExplorer.getPlayerCharacter(), usePhase);
                    usePhase++;
                    if(usePhase > ((IUsable) activeItem).getUsageRotationLimit()){
                        usePhase=0;
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
        useItem = false;
    }

    public MouseInputHandler(Stage primaryStage){

        primaryStage.getScene().setOnMousePressed(e->{
            if(!KeyInputHandler.blockInputEvents()) {
                useItem = true;
            }
        });
        primaryStage.getScene().setOnMouseReleased(e->{
            if(!KeyInputHandler.blockInputEvents()){
                useItem = false;
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
                    ActionBar.moveSelectionDown();
                } else {
                    ActionBar.moveSelectionUp();
                }
            }
        });
    }
}
