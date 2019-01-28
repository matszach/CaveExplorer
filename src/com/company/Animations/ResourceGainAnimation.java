package com.company.Animations;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.Scenes.MainGameScene;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ResourceGainAnimation extends HBox {

    // ImageView
    private ImageView imageView = new ImageView();
    private void buildImageView(int resourceNum){
        imageView.setImage(ImageBank.getResourceIcons());
        imageView.setViewport(new Rectangle2D(2+resourceNum*9,2,6.5,6.5));
        imageView.setOpacity(0.8);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
    }

    // Text
    private Text text = new Text();
    private void buildText(int amount){
        text.setStyle("-fx-font: 14 arial;");
        text.setText("+"+amount);
    }


    // animation cycle
    private int animationLoop = 0;

    public void play(){

        relocate(CaveExplorer.getPlayerCharacter().getTileX()*GameValues.getTileSideLength()+5,
                CaveExplorer.getPlayerCharacter().getTileY()*GameValues.getTileSideLength());
        MainGameScene.getBoard().getChildren().add(this);

        ResourceGainAnimation animationInstance = this;

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



    public ResourceGainAnimation(int resourceNum, int amount){
        buildImageView(resourceNum);
        buildText(amount);
        setSpacing(2);
        getChildren().addAll(imageView, text);
    }
}
