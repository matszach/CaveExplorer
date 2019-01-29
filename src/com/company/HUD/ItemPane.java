package com.company.HUD;

import com.company.CaveExplorer;
import com.company.GameValues;
import com.company.HUD.DragAndDropHandler.InventoryDragAndDropHandler;
import com.company.Items.Item;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;

public class

ItemPane extends StackPane {

    //position in grid
    private int col;
    private int row;


    // held item
    public void buildItemView() {
        Item refItem = CaveExplorer.getPlayerCharacter().getInventory().getItemsInInventory()[col][row];
        if (refItem != null){
            getChildren().remove(itemImageView);
            itemImageView = refItem.buildImageView();
            itemImageView.setFitWidth(28);
            itemImageView.setFitHeight(28);
            getChildren().add(itemImageView);
        } else {
            getChildren().remove(itemImageView);
        }
    }



    // shown item's imageView
    private ImageView itemImageView = new ImageView();

    public void select(){
        setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
        setScaleX(1.05);
        setScaleX(1.05);
    }

    public void unSelect(){
        setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
        setScaleX(1.00);
        setScaleX(1.00);
    }

    public ItemPane(int col, int row){

        this.col = col;
        this.row = row;
        setPrefSize(40,40);
        setBackground(new Background(new BackgroundFill(GameValues.GUI_OVERLAY_BLUE, new CornerRadii(10), new Insets(5,5,5,5))));
        setAlignment(Pos.CENTER);
        buildItemView();

        setOnMouseEntered(e->select());
        setOnMouseExited(e->unSelect());


        // Mouse event handlers for the source
        setOnMousePressed(e->{
            setMouseTransparent(true);
            e.setDragDetect(true);

            InventoryDragAndDropHandler.readySelectedItem(row,col);

            System.out.println("mouse pressed at (" + row + "," + col + ")");
        });

        setOnMouseReleased(e->{
            setMouseTransparent(false);

            InventoryDragAndDropHandler.swapIfReady();
            InventoryDragAndDropHandler.unreadySelectedItem();
            buildItemView();

            System.out.println("mouse released at (" + row + "," + col + ")");
        });

        setOnMouseDragged(e->{
            e.setDragDetect(false);

            // System.out.println("mouse dragged at (" + row + "," + col + ")");
        });

        setOnDragDetected(e-> {
            startFullDrag();

            System.out.println("drag detected at (" + row + "," + col + ")");
        });

        // Mouse event handlers for the target
        setOnMouseDragEntered(e-> {

            InventoryDragAndDropHandler.readyTargetedItem(row, col);

            System.out.println("mouse drag entered at (" + row + "," + col + ")");
        });

        setOnMouseDragOver(e-> {
            // System.out.println("mouse dragged over at (" + row + "," + col + ")");
        });

        setOnMouseDragReleased(e-> {
            //targetFld.setText(sourceFld.getSelectedText());
            System.out.println("mouse drag released at (" + row + "," + col + ")");
        });

        setOnMouseDragExited(e-> {
            InventoryDragAndDropHandler.unreadyTargetedItem();
            buildItemView();
            System.out.println("mouse drag exited at (" + row + "," + col + ")");
        });





    }

}