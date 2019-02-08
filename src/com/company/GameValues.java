package com.company;

import javafx.scene.paint.Color;

public final class GameValues {
    /**
     * Turns out static primitive values require static getters to prevent them from glitching out
     */
    public static final double TILE_SIDE_LENGTH = 50;
    public static double getTileSideLength(){
        return TILE_SIDE_LENGTH;
    }

    public static final int[] BOARD_SIDE_LENGTH_IN_TILES = new int[]{2000,5000,10000};
    public static int[] getBoardSideLengthInTiles(){
        return BOARD_SIDE_LENGTH_IN_TILES;
    }

    public static final int BEDROCK_WIDTH = 6;
    public static int getBedrockWidth(){
        return BEDROCK_WIDTH;
    }

    public static final double WINDOW_SIDE_LENGTH = 600;
    public static double getWindowSideLength(){
        return WINDOW_SIDE_LENGTH;
    }


    // gui colors
    public static final Color GUI_FULL_BLUE = new Color(0.1,0.3,0.6,0.8);
    public static final Color GUI_FULL_BLUE_OPAQUE = new Color(0.1,0.3,0.6,0.8);
    public static final Color GUI_FLASH_BLUE = new Color(0.2,0.7,0.8,0.8);
    public static final Color GUI_MAIN_BLUE = new Color(0.1,0.6,0.9,0.7);
    public static final Color GUI_OVERLAY_BLUE = new Color(0.1,0.7,1,0.4);
    public static final Color GUI_OVERLAY_BLUE_OPAQUE = new Color(0.1,0.7,1,1);
    public static final Color HP_BAR_FRONT = new Color(0.6,0.1,0.1,1);
    public static final Color HP_BAR_BASE = new Color(0.3,0.1,0.1,1);

    // other colors
    public static final Color HEALING_GREEN = new Color(0.4,0.7,0.1,1);



}

