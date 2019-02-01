package com.company.Animations;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.Items.Item;
import com.company.Scenes.MainGameScene;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ItemGainAnimation extends HBox {

    // ImageView
    private ImageView imageView = new ImageView();
    private void buildImageView(Item item){
        imageView = item.buildImageView();
        imageView.setOpacity(0.8);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
    }

    // Text
    private Text text = new Text();
    private void buildText(){
        text.setStyle("-fx-font: 14 arial;");
        text.setText("+");
    }


    // animation cycle
    private int animationLoop = 0;

    public void play(){

        relocate(CaveExplorer.getPlayerCharacter().getTileX()* GameValues.getTileSideLength()+5,
                CaveExplorer.getPlayerCharacter().getTileY()*GameValues.getTileSideLength());
        MainGameScene.getBoard().getChildren().add(this);

        ItemGainAnimation animationInstance = this;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if(animationLoop >= 25){
                    stop();
                    MainGameScene.getBoard().getChildren().remove(animationInstance);
                } else {
                    relocate(CaveExplorer.getPlayerCharacter().getTileX()*GameValues.getTileSideLength()+5,
                            CaveExplorer.getPlayerCharacter().getTileY()*GameValues.getTileSideLength()-animationLoop);
                    animationLoop += 1;
                }

            }
        };
        timer.start();
    }



    public ItemGainAnimation(Item item){
        buildImageView(item);
        buildText();
        setSpacing(2);
        getChildren().addAll(text,imageView);
    }
}