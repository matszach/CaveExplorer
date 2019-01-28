package com.company;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Tiles.Tile_Const_StoneWall;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public final class KeyInputHandler {

    // movement
    private final static KeyCombination MOVE_LEFT = new KeyCodeCombination(KeyCode.A);
    private final static KeyCombination MOVE_UP = new KeyCodeCombination(KeyCode.W);
    private final static KeyCombination MOVE_RIGHT = new KeyCodeCombination(KeyCode.D);
    private final static KeyCombination MOVE_DOWN = new KeyCodeCombination(KeyCode.S);
    private static boolean movingLeft, movingUp, movingRight, movingDown;


    // this might be changed later
    // the space bar will be used for all player actions and keys 1-9 will be used for choosing the current player action on space bar press
    private final static KeyCombination REPLACE_TILE = new KeyCodeCombination(KeyCode.E);
    private static boolean targeting;

    // opens and closes inventory
    private final static KeyCombination INVENTORY_TOGGLE = new KeyCodeCombination(KeyCode.I);
    private static boolean inventoryOpen;

    // opens and closes pause menu
    private final static  KeyCombination PAUSE_TOGGLE_1 = new KeyCodeCombination(KeyCode.ESCAPE);
    private final static  KeyCombination PAUSE_TOGGLE_2 = new KeyCodeCombination(KeyCode.P);
    private static boolean pauseOpen;

    public static boolean blockInputEvents(){
        return inventoryOpen || pauseOpen ;
    }


    private static AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(!blockInputEvents()){

                if (movingLeft){
                    CaveExplorer.getPlayerCharacter().walk(PlayerCharacter.MOVE_DIR.LEFT);
                }
                if (movingRight){
                    CaveExplorer.getPlayerCharacter().walk(PlayerCharacter.MOVE_DIR.RIGHT);
                }
                if (movingUp){
                    CaveExplorer.getPlayerCharacter().walk(PlayerCharacter.MOVE_DIR.UP);
                }
                if (movingDown){
                    CaveExplorer.getPlayerCharacter().walk(PlayerCharacter.MOVE_DIR.DOWN);
                }
                if (targeting){
                    // TODO WIP
                    CaveExplorer.getPlayerCharacter().targetTile();
                    targeting = false;
                }

            } // if inventory open

        }
    };

    public static void start(){
        timer.start();
    }
    public static void stop(){
        timer.stop();
    }
    public static void reset(){
        movingLeft= false;
        movingUp = false;
        movingRight = false;
        movingDown = false;
        targeting = false;
        inventoryOpen = false;
        pauseOpen = false;
    }


    // constructor
    public KeyInputHandler(Stage primaryStage) {

        primaryStage.getScene().setOnKeyPressed(ke -> {
            if (MOVE_LEFT.match(ke)) {
                movingLeft = true;
            }
            if(MOVE_UP.match(ke)){
                movingUp = true;
            }
            if(MOVE_RIGHT.match(ke)){
                movingRight = true;
            }
            if(MOVE_DOWN.match(ke)){
                movingDown = true;
            }
            if(REPLACE_TILE.match(ke)){
                // TODO WIP
                targeting = true;
            }
            if(INVENTORY_TOGGLE.match(ke)){
                if(!pauseOpen){
                    if(inventoryOpen){
                        CaveExplorer.closeInventory();
                        inventoryOpen = false;
                    } else {
                        CaveExplorer.openInventory();
                        inventoryOpen = true;
                    }
                }
            }
            if(PAUSE_TOGGLE_1.match(ke) || PAUSE_TOGGLE_2.match(ke)){
                if(inventoryOpen) {
                    CaveExplorer.closeInventory();
                    inventoryOpen = false;
                }
                if(pauseOpen){
                    CaveExplorer.closePauseWindow();
                    pauseOpen = false;
                } else {
                    CaveExplorer.openPauseWindow();
                    pauseOpen = true;
                }
            }


        });

        primaryStage.getScene().setOnKeyReleased(ke -> {
            if (MOVE_LEFT.match(ke)) {
                movingLeft = false;
            }
            if(MOVE_UP.match(ke)){
                movingUp = false;
            }
            if(MOVE_RIGHT.match(ke)){
                movingRight = false;
            }
            if(MOVE_DOWN.match(ke)){
                movingDown = false;
            }
            if(REPLACE_TILE.match(ke)){
                // TODO WIP
                CaveExplorer.getPlayerCharacter().buildTile(new Tile_Const_StoneWall());
            }
        });


    }
}
