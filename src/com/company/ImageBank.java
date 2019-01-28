package com.company;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public final class ImageBank {

    private static Image mapTiles1;
    public static Image getMapTiles1() {
        return mapTiles1;
    }

    private static Image tileDamage;
    public static Image getTileDamage() {
        return tileDamage;
    }

    private static Image itemTiles1;
    public static Image getItemTiles1() {
        return itemTiles1;
    }

    private static Image agentTiles1;
    public static Image getAgentTiles1() {
        return agentTiles1;
    }

    private static Image resourceIcons;
    public static Image getResourceIcons() {
        return resourceIcons;
    }

    private static Image menuBackground;
    public static Image getMenuBackground() {
        return menuBackground;
    }

    private static Image logo;
    public static Image getLogo() {
        return logo;
    }

    public ImageBank(){

        try{
            mapTiles1 = new Image(new FileInputStream("Images\\mapTiles_1.png"));
            tileDamage = new Image(new FileInputStream("Images\\tileDamage.png"));
            itemTiles1 = new Image(new FileInputStream("Images\\items_1.png"));
            agentTiles1 = new Image(new FileInputStream("Images\\agentTiles_1.png"));
            resourceIcons = new Image(new FileInputStream("Images\\resourceIcons.png"));
            menuBackground = new Image(new FileInputStream("Images\\menuBackground.png"));
            logo = new Image(new FileInputStream("Images\\logo.png"));
        } catch (Exception e){

        }






    }
}
