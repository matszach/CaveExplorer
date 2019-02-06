package com.company.Scenes;

import com.company.Board.Board;
import com.company.Board.BoardBuilder.BoardBuilder;
import com.company.HUD.GameOverWindow;
import com.company.HUD.HUD;
import com.company.HUD.InventoryWindow.InventoryWindow;
import com.company.HUD.PauseWindow;
import com.company.HUD.SaveWindow;
import javafx.scene.layout.Pane;

public class MainGameScene extends Pane {

    // The Board
    private static Board board;
    public static Board getBoard() {
        return board;
    }

    // The HUD
    private static HUD hud = new HUD();
    public static HUD getHud() {
        return hud;
    }

    // The Inventory Window
    private static InventoryWindow inventoryWindow = new InventoryWindow();
    public static InventoryWindow getInventoryWindow() {
        return inventoryWindow;
    }
    public static void setInventoryWindow(InventoryWindow inventoryWindow) {
        MainGameScene.inventoryWindow = inventoryWindow;
    }

    // The Pause Window
    private static PauseWindow pauseWindow = new PauseWindow();
    public static PauseWindow getPauseWindow() {
        return pauseWindow;
    }

    // The Save Window
    private static SaveWindow saveWindow = new SaveWindow();
    public static SaveWindow getSaveWindow() {
        return saveWindow;
    }

    // The Game Over Window
    private static GameOverWindow gameOverWindow = new GameOverWindow();
    public static GameOverWindow getGameOverWindow() {
        return gameOverWindow;
    }

    public MainGameScene(int sideLengthInTiles, double oreAmount, double terrainAmount, double structureAmount){
        board = BoardBuilder.buildBoard(sideLengthInTiles, oreAmount, terrainAmount, structureAmount);
        getChildren().add(board);
        getChildren().add(hud);
        getInventoryWindow().initiate();
    }

    public MainGameScene(int[][] readyBoardTypes){
        board = new Board(readyBoardTypes);
        getChildren().add(board);
        getChildren().add(hud);
        getInventoryWindow().initiate();
    }
}
