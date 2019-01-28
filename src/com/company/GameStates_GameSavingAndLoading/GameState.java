package com.company.GameStates_GameSavingAndLoading;

import com.company.Agent.PlayerCharacter.PlayerCharacter;

public class GameState {

    // Player
    private PlayerCharacter playerCharacter;
    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    private int playerPosX;
    public void setPlayerPosX(int playerPosX) {
        this.playerPosX = playerPosX;
    }
    public int getPlayerPosX() {
        return playerPosX;
    }

    private int playerPosY;
    public void setPlayerPosY(int playerPosY) {
        this.playerPosY = playerPosY;
    }
    public int getPlayerPosY() {
        return playerPosY;
    }

    // board
    private int[][] boardTileInfo;
    public void setBoardTileInfo(int[][] boardTileInfo) {
        this.boardTileInfo = boardTileInfo;
    }
    public int[][] getBoardTileInfo() {
        return boardTileInfo;
    }
    public void setOneTile(int x, int y, int tileType){
        boardTileInfo[x][y] = tileType;
    }
}
