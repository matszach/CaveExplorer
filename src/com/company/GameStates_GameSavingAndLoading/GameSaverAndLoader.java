package com.company.GameStates_GameSavingAndLoading;

import com.company.Agent.PlayerCharacter.PlayerCharacter;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GameSaverAndLoader {

    private GameSaverAndLoader instance = new GameSaverAndLoader();

    private static PrintWriter writer;
    private static Scanner scanner;


    private static DecimalFormat tileNumber = new DecimalFormat("000");
    private static DecimalFormat playerLocationNumber = new DecimalFormat("00000");
    private static DecimalFormat resourceAmountNumber = new DecimalFormat("000000");

    public static void saveToFile(GameState gameState, int saveNum){
        try{
            writer = new PrintWriter("GameStates\\gameState"+saveNum+".save", "UTF-8");
        } catch (Exception e){ }

        // player location
        writer.println(playerLocationNumber.format(gameState.getPlayerPosX()));
        writer.println(playerLocationNumber.format(gameState.getPlayerPosY()));

        // players resources
        for(int i = 0; i < 10; i++){
            writer.println(resourceAmountNumber.format(gameState.getPlayerCharacter().getInventory().getResource(i).getAmount()));
        }

        // board sideLengths
        writer.println(playerLocationNumber.format(gameState.getBoardTileInfo().length));
        writer.println(playerLocationNumber.format(gameState.getBoardTileInfo()[0].length));

        // board itself
        for(int x = 0; x < gameState.getBoardTileInfo().length; x++){
            for(int y = 0; y < gameState.getBoardTileInfo()[0].length; y++){
                String fieldNum = tileNumber.format(gameState.getBoardTileInfo()[x][y]);
                writer.print(fieldNum+" ");
            }
            writer.println();
        }


        writer.close();
    }

    public static GameState loadFromFile(int saveNum){

        try{
            scanner = new Scanner(new FileInputStream("GameStates\\gameState"+saveNum+".save"));
        } catch (Exception e){ }

        GameState gameState = new GameState();

        // player location
        gameState.setPlayerPosX(Integer.parseInt(scanner.nextLine()));
        gameState.setPlayerPosY(Integer.parseInt(scanner.nextLine()));

        // players resources
        gameState.setPlayerCharacter(new PlayerCharacter());
        for(int i = 0; i < 10; i++){
            gameState.getPlayerCharacter().getInventory().getResource(i).gain(Integer.parseInt(scanner.nextLine()));
        }

        // board sideLengths
        int xLength = Integer.parseInt(scanner.nextLine());
        int yLength = Integer.parseInt(scanner.nextLine());
        gameState.setBoardTileInfo(new int[xLength][yLength]);

        // board itself
        for(int x = 0; x < gameState.getBoardTileInfo().length; x++){
            for(int y = 0; y < gameState.getBoardTileInfo()[0].length; y++){
                String tileNum = scanner.next();
                gameState.setOneTile(x, y, Integer.parseInt(tileNum));
            }
        }

        return gameState;


    }





    private GameSaverAndLoader() {
    }
}
