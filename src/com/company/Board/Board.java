package com.company.Board;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.MonsterSpawnerAndHandler;
import com.company.Scenes.MainGameScene;
import com.company.Tiles.Tile;
import com.company.Tiles.TileTypes;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Board extends Pane {

    // board tile type array - holds what, if any, tile is to be where.
    private int[][] boardTileTypes;

    public int[][] getBoardTileTypes() {
        return boardTileTypes;
    }

    public void setBoardTileTypes(int[][] boardTileTypeArray) {
        this.boardTileTypes = boardTileTypeArray;
    }

    // tile reference array - for easy access to already placed tiles
    private Tile[][] tiles;

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    // board side length in pixels -> used for easier drawing, might get replaced later
    private double boardSideLength;

    public void setBoardSideLength(double boardSideLength) {
        this.boardSideLength = boardSideLength;
    }

    // draws vertical and horizontal lines indicating tiles
    private void drawGrid() {
        for (double i = 0; i < boardSideLength + 2; i += GameValues.getTileSideLength()) {
            Line vLine = new Line(0, i, boardSideLength, i);
            double strokeWidth = i == 0 || i + GameValues.getTileSideLength() > boardSideLength ? 30 : 2;
            vLine.setStrokeWidth(strokeWidth);
            Line hLine = new Line(i, 0, i, boardSideLength);
            hLine.setStrokeWidth(strokeWidth);
            getChildren().addAll(vLine, hLine);
        }
    }

    // places a tile in a specific "tile-space" - also references it
    public void drawTile(Tile tile, int x, int y) {
        if (tile != null) {
            //to prevent unlisted but visible rectangles
            if (getTiles()[x][y] != null) {
                getChildren().remove(getTiles()[x][y]);
            }
            tile.relocate(x * GameValues.getTileSideLength(), y * GameValues.getTileSideLength());
            getChildren().add(tile);
            tiles[x][y] = tile;
            tile.x = x;
            tile.y = y;

            MonsterSpawnerAndHandler.spawnAttempt(x, y);
        }
    }

    // Used to "draw-over" an existing tile to replace it
    public void replaceTile(Tile newTile, int x, int y) {
        drawTile(newTile, x, y);
        getBoardTileTypes()[x][y] = TileTypes.getNumFromTile(newTile.getClass());
        CaveExplorer.getPlayerCharacter().toFront();
    }


    // generates tile from an integer "id number"
    private Tile generateTile(int tileNum) {
        return TileTypes.getTileFromNum(tileNum);
    }


    // draws tiles in a specific area around the player's position, used for occlusion culling
    public void drawNearbyTiles(int range) {

        int xMin = CaveExplorer.getPlayerCharacter().roundTileX() - range >= 0 ? CaveExplorer.getPlayerCharacter().roundTileX() - range : 0;
        int yMin = CaveExplorer.getPlayerCharacter().roundTileY() - range >= 0 ? CaveExplorer.getPlayerCharacter().roundTileY() - range : 0;
        int xMax = CaveExplorer.getPlayerCharacter().roundTileX() + range <= MainGameScene.getBoard().getBoardTileTypes().length ? CaveExplorer.getPlayerCharacter().roundTileX() + range : MainGameScene.getBoard().getBoardTileTypes().length;
        int yMax = CaveExplorer.getPlayerCharacter().roundTileY() + range <= MainGameScene.getBoard().getBoardTileTypes().length ? CaveExplorer.getPlayerCharacter().roundTileY() + range : MainGameScene.getBoard().getBoardTileTypes().length;

        for (int x = xMin; x < xMax; x++) {
            for (int y = yMin; y < yMax; y++) {
                if (getTiles()[x][y] == null) {
                    drawTile(generateTile(getBoardTileTypes()[x][y]), x, y);
                }
            }
        }
        CaveExplorer.getPlayerCharacter().toFront();
    }

    // culls distant tiles
    public void cullDistantTiles(int range, int cullWidth) {

        int xMin = CaveExplorer.getPlayerCharacter().roundTileX() - range >= 0 ? CaveExplorer.getPlayerCharacter().roundTileX() - range : 0;
        int yMin = CaveExplorer.getPlayerCharacter().roundTileY() - range >= 0 ? CaveExplorer.getPlayerCharacter().roundTileY() - range : 0;
        int xMax = CaveExplorer.getPlayerCharacter().roundTileX() + range <= MainGameScene.getBoard().getBoardTileTypes().length ? CaveExplorer.getPlayerCharacter().roundTileX() + range : MainGameScene.getBoard().getBoardTileTypes().length;
        int yMax = CaveExplorer.getPlayerCharacter().roundTileY() + range <= MainGameScene.getBoard().getBoardTileTypes().length ? CaveExplorer.getPlayerCharacter().roundTileY() + range : MainGameScene.getBoard().getBoardTileTypes().length;

        if (xMin > cullWidth) {
            for (int x = xMin; x < xMin + cullWidth; x++) {
                for (int y = yMin; y < yMax; y++) {
                    getChildren().remove(getTiles()[x][y]);
                    getTiles()[x][y] = null;
                }
            }
        }

        if (yMax < MainGameScene.getBoard().getBoardTileTypes()[0].length - cullWidth) {
            for (int x = xMax - cullWidth; x < xMax; x++) {
                for (int y = yMin; y < yMax; y++) {
                    getChildren().remove(getTiles()[x][y]);
                    getTiles()[x][y] = null;
                }
            }
        }

        if (yMin > cullWidth) {
            for (int x = xMin; x < xMax; x++) {
                for (int y = yMin; y < yMin + cullWidth; y++) {
                    getChildren().remove(getTiles()[x][y]);
                    getTiles()[x][y] = null;
                }
            }
        }

        if (xMax < MainGameScene.getBoard().getBoardTileTypes().length - cullWidth) {
            for (int x = xMin; x < xMax; x++) {
                for (int y = yMax - cullWidth; y < yMax; y++) {
                    getChildren().remove(getTiles()[x][y]);
                    getTiles()[x][y] = null;
                }
            }
        }
    }

    // constructor
    public Board(int[][] boardTileTypes) {
        setBoardTileTypes(boardTileTypes);
        setBoardSideLength(getBoardTileTypes().length * GameValues.getTileSideLength());
        setTiles(new Tile[getBoardTileTypes().length][getBoardTileTypes().length]);
        setMaxSize(boardSideLength, boardSideLength);
        setMinSize(boardSideLength, boardSideLength);
    }
}
