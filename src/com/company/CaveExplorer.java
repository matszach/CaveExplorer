package com.company;

import com.company.Agent.Agent;
import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.GameStates_GameSavingAndLoading.GameState;
import com.company.HUD.SaveWindow;
import com.company.Scenes.MainGameScene;
import com.company.Scenes.StartMenuScene;
import com.company.Tiles.TileTypes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.Stage;


public final class CaveExplorer extends Application {

    // The Databases
    private static TileTypes tileTypes = new TileTypes();
    private static ImageBank imageBank = new ImageBank();


    // The Player
    private static PlayerCharacter playerCharacter;
    public static PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }


    // The root of menu scene
    private static StartMenuScene startMenuScene = new StartMenuScene();
    public static StartMenuScene getStartMenuScene() {
        return startMenuScene;
    }
    // The root of game scene
    private static MainGameScene mainGameScene;
    public static MainGameScene getMainGameScene() {
        return mainGameScene;
    }
    public static void setMainGameScene(MainGameScene mainGameScene) {
        CaveExplorer.mainGameScene = mainGameScene;
    }

    // Stage resize listener handler
    private static StageResizeListener stageResizeListener;
    // Key Input Handler
    private static KeyInputHandler keyInputHandler;
    // Mouse Input Handler
    private static MouseInputHandler mouseInputHandler;
    // Renderer
    private static Renderer renderer;




    // Move View methods
    public static void moveView(double x, double y){
        MainGameScene.getBoard().relocate(MainGameScene.getBoard().getLayoutX()+x, MainGameScene.getBoard().getLayoutY()+y);
    }
    // View alteration
    public static void moveView(Agent.MOVE_DIR move_dir){
        switch (move_dir){
            case LEFT: moveView(getPlayerCharacter().getMovementSpeed()*GameValues.getTileSideLength(), 0); break;
            case UP: moveView( 0,getPlayerCharacter().getMovementSpeed()*GameValues.getTileSideLength()); break;
            case RIGHT: moveView(-getPlayerCharacter().getMovementSpeed()*GameValues.getTileSideLength(), 0); break;
            case DOWN: moveView( 0,-getPlayerCharacter().getMovementSpeed()*GameValues.getTileSideLength()); break;
        }
    }
    public static void updateView(){
        double moveByX = -getPlayerCharacter().getPositionX()+300;
        double moveByY = -getPlayerCharacter().getPositionY()+300;
        moveView(moveByX, moveByY);
    }



    // Window invokers <- those will be moved TODO
    public static void openInventory(){
        mainGameScene.getChildren().add(MainGameScene.getInventoryWindow());
        MainGameScene.getBoard().setEffect(new GaussianBlur());
    }
    public static void closeInventory(){
        mainGameScene.getChildren().remove(MainGameScene.getInventoryWindow());
        MainGameScene.getBoard().setEffect(null);
    }
    public static void openPauseWindow(){
        mainGameScene.getChildren().add(MainGameScene.getPauseWindow());
        MainGameScene.getBoard().setEffect(new GaussianBlur());
        MainGameScene.getHud().setEffect(new GaussianBlur());
    }
    public static void closePauseWindow(){
        mainGameScene.getChildren().remove(MainGameScene.getPauseWindow());
        MainGameScene.getBoard().setEffect(null);
        MainGameScene.getHud().setEffect(null);
    }
    public static void openSaveWindow(){
        mainGameScene.getChildren().add(MainGameScene.getSaveWindow());
        SaveWindow.updateSaveFileButtons();
        mainGameScene.getChildren().remove(MainGameScene.getPauseWindow());
    }
    public static void closeSaveWindow(){
        mainGameScene.getChildren().remove(MainGameScene.getSaveWindow());
        mainGameScene.getChildren().add(MainGameScene.getPauseWindow());
    }




    
    // Scenes and switching between them
    public static Stage mainStage;
    private static Scene menuScene = new Scene(startMenuScene, GameValues.getWindowSideLength(),GameValues.getWindowSideLength());
    private static Scene gameScene;

    public static void showStartMenu(){
        mainStage.setScene(menuScene);
        mainStage.setResizable(false);

        startMenuScene.goBackToMainMenu();
        startMenuScene.launchAnimation();

        KeyInputHandler.stop();
        MouseInputHandler.stop();
        Renderer.stop();
    }
    public static void showGame(){

        startMenuScene.freezeAnimation();

        mainStage.setScene(gameScene);
        mainStage.setResizable(true);

        keyInputHandler = new KeyInputHandler(mainStage);
        mouseInputHandler = new MouseInputHandler(mainStage);
        renderer = new Renderer();

        KeyInputHandler.start();
        MouseInputHandler.start();
        Renderer.start();
    }



    // Game saving and loading
    public static GameState getCurrentGameState(){
        GameState gameState = new GameState();
        gameState.setPlayerCharacter(playerCharacter);
        gameState.setPlayerPosX(playerCharacter.roundTileX());
        gameState.setPlayerPosY(playerCharacter.roundTileY());
        gameState.setBoardTileInfo(MainGameScene.getBoard().getBoardTileTypes());
        return gameState;
    }

    public static void startNewGame(int sideLengthInTiles, double oreAmount, double terrainAmount, double structureAmount){
        playerCharacter = new PlayerCharacter();
        mainGameScene = new MainGameScene(sideLengthInTiles, oreAmount, terrainAmount, structureAmount);
        gameScene = new Scene(mainGameScene, GameValues.getWindowSideLength(),GameValues.getWindowSideLength());
        playerCharacter.relocate(GameValues.getTileSideLength()*sideLengthInTiles/2,GameValues.getTileSideLength()*sideLengthInTiles/2+1);
        MainGameScene.getBoard().getChildren().add(playerCharacter);
        updateView();
    }

    public static void loadGame(GameState gameState) {
        playerCharacter = gameState.getPlayerCharacter();
        mainGameScene = new MainGameScene(gameState.getBoardTileInfo());
        gameScene = new Scene(mainGameScene, GameValues.getWindowSideLength(), GameValues.getWindowSideLength());
        playerCharacter.relocate(gameState.getPlayerPosX()*GameValues.getTileSideLength(), gameState.getPlayerPosY()*GameValues.getTileSideLength() + 1);
        MainGameScene.getBoard().getChildren().add(playerCharacter);
        updateView();
    }


        // other actions
    public static void closeGame(){
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) {

        // lets the stag ebe referenced by CaveExplorer static methods
        mainStage = primaryStage;

        // names and shows the stage
        primaryStage.setTitle("Cave Explorer");
        primaryStage.setScene(menuScene);
        primaryStage.show();
        primaryStage.setResizable(false);

        // launches main menu logo animation
        startMenuScene.launchAnimation();

        // Dynamic Window Scaling, always on
        stageResizeListener = new StageResizeListener(primaryStage);


    }

    public static void main(String[] args) {
        launch(args);

    }
}
