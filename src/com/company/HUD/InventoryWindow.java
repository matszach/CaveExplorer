package com.company.HUD;

import com.company.CaveExplorer;
import com.company.GameValues;

import com.company.ImageBank;
import com.company.Items.Item;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class InventoryWindow extends Pane {


    // CRAFT PANE
    private Pane craftPane = new Pane();

    private void buildCraftPane(){
        craftPane.setPrefSize(250,200);
        craftPane.relocate(10,10);
        craftPane.setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));
    }


    // ITEMS PANE
    private Pane itemInventoryPane = new Pane();
    private ItemPane[][] itemPanes = new ItemPane[10][5];

    private void buildItemsPane(){
        itemInventoryPane.getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        itemInventoryPane.setPrefSize(400,200);
        itemInventoryPane.relocate(10,220);
        itemInventoryPane.setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));

        //TODO
        for(int x = 0; x <itemPanes.length; x++){
            for(int y = 0; y <itemPanes[0].length; y++){
                itemPanes[x][y] = new ItemPane(x,y);
                placeInItemPane(itemPanes[x][y], x, y);
            }
        }
    }



    // RESOURCE PANE
    private VBox resourcePane = new VBox();

    private ResourceBox[] resourceBoxes = new ResourceBox[10];

    private class ResourceBox extends HBox{
        public ImageView imageView = new ImageView();
        public Text resAmountText = new Text();
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

    private void buildResourcePane(){
        resourcePane.getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        resourcePane.setPrefSize(140,200);
        resourcePane.relocate(270,10);
        resourcePane.setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));
        resourcePane.setAlignment(Pos.CENTER);
        resourcePane.setSpacing(3);
        buildResourceDisplays();
        placeResourceDisplays();
        resUpdater.start();
    }

    private void buildResourceDisplays(){
        for(int i = 0; i < 10; i++){
            resourceBoxes[i] = new ResourceBox();
            resourceBoxes[i].imageView.setViewport(new Rectangle2D(2+i*9,2,6.5,6.5));
        }
    }
    private void placeResourceDisplays(){
        for(ResourceBox rb : resourceBoxes){
            resourcePane.getChildren().add(rb);
        }
    }
    private void updateResourceDisplays(){
        for(int i = 0; i < 10; i++){
            resourceBoxes[i].resAmountText.setText(""+CaveExplorer.getPlayerCharacter().getInventory().getResource(i).getAmount());
        }
    }


    private AnimationTimer resUpdater = new AnimationTimer() {
        @Override
        public void handle(long now) {
            updateResourceDisplays();
        }
    };


    private void placeInItemPane(Node node, int xRow, int yRow){
        node.relocate(xRow*40, yRow*40);
        itemInventoryPane.getChildren().add(node);
    }

    // initiates the inventory window
    public void initiate(){
        getChildren().clear(); // <- !!! this allows the game to switch from menu to game-view
        buildCraftPane();
        buildResourcePane();
        buildItemsPane();
        getChildren().addAll(craftPane,resourcePane, itemInventoryPane);
    }


    // updates imageView (for when item is removed / used)
    public void updateItemPane(int col, int row){
        if(row <= 4){
            itemPanes[col][row].buildItemView();
        } else {
            ActionBar.getActionOptionPanes()[col].buildItemView();
        }

    }

    public InventoryWindow(){

        relocate(95,100);
        setPrefSize(420,430);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10),null)));





    }
}
