package com.company.HUD.InventoryWindow;

import com.company.GameValues;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

;

public class CraftingPane extends ScrollPane {

    private final double PREF_WIDTH = 250;
    private final double PREF_HEIGHT = 200;




    // inner class : single crafting recipe pane
    private class CraftingRecipePane extends Pane{


        public CraftingRecipePane(){
            setPrefSize(PREF_WIDTH-9, 30);
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FLASH_BLUE, new CornerRadii(5), null)));


            Text t = new Text("a crafting recipe");
            t.relocate(5,5);
            getChildren().add(t);

        }

    }


    // inner class : craft recipe pane holder
    private class RecipePaneHolder extends VBox{

        private final double SPACING = 5;

        public void addARecipes(CraftingRecipePane... recipePanes){
            for(CraftingRecipePane crp : recipePanes){
                getChildren().add(crp);
                setHeight(getHeight()+crp.getHeight()+SPACING);
            }

        }


        public RecipePaneHolder(){
            setMinWidth(PREF_WIDTH-9);
            setAlignment(Pos.CENTER);
            setSpacing(SPACING);
            // color recreated manually because of scroll-pane opacity problems
            setBackground(new Background(new BackgroundFill(new Color(0.1,0.6, 1, 1), new CornerRadii(5), null)));

            addARecipes(
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane(),
                    new CraftingRecipePane());

        }
    }





    public CraftingPane(){
        setPrefSize(PREF_WIDTH, PREF_HEIGHT);
        relocate(10,10);
        setStyle("-fx-padding: 5 5 5 5;");
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));

        // makes scroll bar invisible (but doesn't disable mouse scroll wheel)
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollBarPolicy.NEVER);


        setContent(new RecipePaneHolder());

    }
}
