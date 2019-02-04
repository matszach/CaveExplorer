package com.company.HUD.InventoryWindow;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.ImageBank;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class ResourcePane extends VBox {

    private ResourceBox[] resourceBoxes = new ResourceBox[10];

    private class ResourceBox extends HBox {
        private ImageView imageView = new ImageView();
        private Text resAmountText = new Text();
        private ResourceBox(){
            setPadding(new Insets(0,10,0,10));
            setSpacing(15);
            getChildren().addAll(imageView, resAmountText);
            imageView.setImage(ImageBank.getResourceIcons());
            imageView.setOpacity(0.8);
            imageView.setFitWidth(16);
            imageView.setFitHeight(16);
        }
    }


    private void buildResourceDisplays(){
        for(int i = 0; i < 10; i++){
            resourceBoxes[i] = new ResourceBox();
            resourceBoxes[i].imageView.setViewport(new Rectangle2D(2+i*9,2,6.5,6.5));
        }
    }
    private void placeResourceDisplays(){
        for(ResourceBox rb : resourceBoxes){
            getChildren().add(rb);
        }
    }
    private void updateResourceDisplays(){
        for(int i = 0; i < 10; i++){
            resourceBoxes[i].resAmountText.setText(""+ CaveExplorer.getPlayerCharacter().getInventory().getResource(i).getAmount());
        }
    }


    private AnimationTimer resUpdater = new AnimationTimer() {
        @Override
        public void handle(long now) {
            updateResourceDisplays();
        }
    };


    public ResourcePane(){
        getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        setPrefSize(140,200);
        relocate(270,10);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));
        setAlignment(Pos.CENTER);
        setSpacing(3);
        buildResourceDisplays();
        placeResourceDisplays();
        resUpdater.start();



    }
}
