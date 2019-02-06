package com.company.GameStates_GameSavingAndLoading;

import com.company.Agent.PlayerCharacter.PlayerCharacter;
import com.company.Items.Item;
import com.company.Items.ItemTypes;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GameSaverAndLoader {

    private GameSaverAndLoader instance = new GameSaverAndLoader();

    private static PrintWriter writer;
    private static Scanner scanner;


    private static DecimalFormat shortNum = new DecimalFormat("000");
    private static DecimalFormat mediumNum = new DecimalFormat("00000");
    private static DecimalFormat longNum = new DecimalFormat("000000");

    public static void saveToFile(GameState gameState, int saveNum){
        try{
            writer = new PrintWriter("GameStates\\gameState"+saveNum+".save", "UTF-8");
        } catch (Exception e){ }

        // board sideLengths
        writer.println(mediumNum.format(gameState.getBoardTileInfo().length));
        writer.println(mediumNum.format(gameState.getBoardTileInfo()[0].length));

        // player's location
        writer.println(mediumNum.format(gameState.getPlayerPosX()));
        writer.println(mediumNum.format(gameState.getPlayerPosY()));

        // player's health
        writer.println(shortNum.format(gameState.getPlayerCharacter().getCurrentHealth()));

        // player's resources
        for(int i = 0; i < 10; i++){
            writer.println(longNum.format(gameState.getPlayerCharacter().getInventory().getResource(i).getAmount()));
        }

        // player's items
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 10; col++){

                int itemNum;

                if(gameState.getPlayerCharacter().getInventory().getItemsInInventory()[col][row] == null){
                    itemNum = 0;
                } else {
                    itemNum = ItemTypes.getNumFromItem(gameState.getPlayerCharacter().getInventory().getItemsInInventory()[col][row].getClass());
                }

                String itemNumString = shortNum.format(itemNum);
                writer.print(itemNumString + " ");
            }
            writer.println();
        }



        // board itself
        for(int x = 0; x < gameState.getBoardTileInfo().length; x++){
            for(int y = 0; y < gameState.getBoardTileInfo()[0].length; y++){
                String fieldNum = shortNum.format(gameState.getBoardTileInfo()[x][y]);
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

        // board sideLengths
        int xLength = Integer.parseInt(scanner.nextLine());
        int yLength = Integer.parseInt(scanner.nextLine());
        gameState.setBoardTileInfo(new int[xLength][yLength]);

        // player's location
        gameState.setPlayerPosX(Integer.parseInt(scanner.nextLine()));
        gameState.setPlayerPosY(Integer.parseInt(scanner.nextLine()));


        // player's health
        gameState.setPlayerCharacter(new PlayerCharacter());
        gameState.getPlayerCharacter().setCurrentHealth(Integer.parseInt(scanner.nextLine()));

        // player's resources
        for(int i = 0; i < 10; i++){
            gameState.getPlayerCharacter().getInventory().getResource(i).gain(Integer.parseInt(scanner.nextLine()));
        }

        // player's items
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 10; col++){

                String itemNumString = scanner.next();
                int itemNum = Integer.parseInt(itemNumString);

                Item item;
                if(itemNum == 0){
                    item = null;
                } else {
                    item = ItemTypes.getItemFromNum(Integer.parseInt(itemNumString));
                }

                gameState.getPlayerCharacter().getInventory().loadItemIntoSlot(item,col,row);
        }
        }




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
