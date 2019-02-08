package com.company;

import com.company.Scenes.MainGameScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public final class PngMapGenerator {

    private PngMapGenerator instance = new PngMapGenerator();

    public static void drawMap(int[][] tileNums)  {

        int width = tileNums.length;
        int height = tileNums[0].length;

        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill all the image with white
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++) {
                int num = MainGameScene.getBoard().getBoardTileTypes()[x][y];
                switch (num){
                    case 0 : g2d.setColor(new Color(150,150,150)); break; // floor
                    case 1 : g2d.setColor(new Color(70,70,70)); break; // stone
                    case 2 : g2d.setColor(new Color(80,60,40)); break; // iron
                    case 3 : g2d.setColor(new Color(20,0,20)); break; // bedrock
                    case 4 : g2d.setColor(new Color(40,40,40)); break; // stone wall
                    case 5 : g2d.setColor(new Color(100,100,200)); break; // platinum
                    case 6 : g2d.setColor(new Color(120,80,10)); break; // wooden support
                    case 7 : g2d.setColor(new Color(0,0,0)); break; // coal
                    case 8 : g2d.setColor(new Color(200,80,10)); break; // copper
                    case 9 : g2d.setColor(new Color(150,150,220)); break; // silver
                    case 10 : g2d.setColor(new Color(120,120,0)); break; // gold
                    case 11 : g2d.setColor(new Color(0,0, 250)); break; // cobalt
                    case 12 : g2d.setColor(new Color(110,0,0)); break; // blood ruby
                    case 13 : g2d.setColor(new Color(200,200, 0)); break; // sulfur
                    case 14 : g2d.setColor(new Color(0,0,80)); break; // water
                    case 15 : g2d.setColor(new Color(250,20,0)); break; // lava
                    case 16 : g2d.setColor(new Color(80,40,0)); break; // crate
                    case 17 : g2d.setColor(new Color(80,80,80)); break; // gravel
                    case 18 : g2d.setColor(new Color(40,40,30)); break; // workshop
                    case 19 : g2d.setColor(new Color(90,40,30)); break; // alchemy lab
                    case 20 : g2d.setColor(new Color(20,20,20)); break; // fireplace
                }
                g2d.drawLine(x, y, x, y);
            }
        }


        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();

        // Save as PNG
        try{
            File file = new File("GameMapDestination\\gameMap.png");
            ImageIO.write(bufferedImage, "png", file);
        } catch (Exception e){

        }

    }


    private PngMapGenerator(){

    }
}
