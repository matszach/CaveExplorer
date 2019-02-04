package com.company.HUD.InventoryWindow;

import com.company.Crafting.CraftingRecipe;
import com.company.Crafting.Weapons.Recipe_CopperSpear;
import com.company.GameValues;
import com.company.Items.Item;
import com.company.Items.Swords.IronSword;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

;

public class CraftingPane extends ScrollPane {

    private final double PREF_WIDTH = 250;
    private final double PREF_HEIGHT = 200;


    // inner class : single crafting recipe pane
    private class CraftingRecipePane extends Pane{




        private void hoverOn(){
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FULL_BLUE, new CornerRadii(5), null)));
        }

        private void hoverOff(){
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FLASH_BLUE, new CornerRadii(5), null)));
        }


        private CraftingRecipePane(CraftingRecipe craftingRecipe){
            setPrefSize(PREF_WIDTH-9, 30);
            setBackground(new Background(new BackgroundFill(GameValues.GUI_FLASH_BLUE, new CornerRadii(5), null)));

            setOnMouseClicked(e->craftingRecipe.execute());

            setOnMouseEntered(e->hoverOn());
            setOnMouseDragEntered(e->hoverOn());
            setOnMouseExited(e->hoverOff());
            setOnMouseDragExited(e->hoverOff());

        }
    }


    // inner class : craft recipe pane holder
    private RecipePaneHolder recipePaneHolder = new RecipePaneHolder();

    private class RecipePaneHolder extends VBox{

        private final double SPACING = 5;

        private void addRecipes(CraftingRecipePane... recipePanes){
            for(CraftingRecipePane crp : recipePanes){
                getChildren().add(crp);
            }
        }

        private void adjustHeight(){
            double newHeight = getChildren().size()*35+5 > PREF_HEIGHT-10 ? getChildren().size()*35+5 : PREF_HEIGHT-10;
            setMinHeight(newHeight);
        }


        private RecipePaneHolder(){
            setMinWidth(PREF_WIDTH-9);
            setAlignment(Pos.CENTER);
            setSpacing(SPACING);
            // color recreated manually because of scroll-pane opacity problems
            setBackground(new Background(new BackgroundFill(new Color(0.1,0.6, 1, 1), new CornerRadii(5), null)));

        }
    }



    public void addRecipesToDisplay(CraftingRecipe... recipes){
        for(CraftingRecipe rec : recipes){
            recipePaneHolder.addRecipes(new CraftingRecipePane(rec));
        }
        recipePaneHolder.adjustHeight();
    }

    public void resetDisplay(){
        recipePaneHolder.getChildren().clear();
        recipePaneHolder.adjustHeight();
    }


    public CraftingPane(){
        setPrefSize(PREF_WIDTH, PREF_HEIGHT);
        relocate(10,10);
        setStyle("-fx-padding: 5 5 5 5;");
        setBackground(new Background(new BackgroundFill(GameValues.GUI_MAIN_BLUE, new CornerRadii(10), null)));

        // makes scroll bar invisible (but doesn't disable mouse scroll wheel)
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollBarPolicy.NEVER);

        setContent(recipePaneHolder);
        recipePaneHolder.adjustHeight();


        // todo temp
        addRecipesToDisplay(new Recipe_CopperSpear(),new Recipe_CopperSpear(),new Recipe_CopperSpear(),new Recipe_CopperSpear() );

    }
}
