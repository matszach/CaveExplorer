package com.company;

import com.company.Scenes.MainGameScene;
import javafx.animation.AnimationTimer;

public final class Renderer {

    private static int mapRenderTimer = 20;
    private static final int RENDER_TIME = 20;

    private static AnimationTimer renderer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(mapRenderTimer > RENDER_TIME){
                MainGameScene.getBoard().drawNearbyTiles(9);
                MainGameScene.getBoard().cullDistantTiles(16, 5);
                MonsterSpawnerAndHandler.despawnDistantMonsters();
                mapRenderTimer=0;
            } else {
                mapRenderTimer++;
            }

        }
    };

    public static void start(){
        renderer.start();
    }
    public static void stop(){
        renderer.stop();
    }

    public Renderer(){
    }
}
