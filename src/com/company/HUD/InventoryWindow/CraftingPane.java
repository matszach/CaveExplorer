package com.company.HUD.InventoryWindow;

import com.company.Crafting.CraftingRecipe;
import com.company.Crafting.Tools.*;
import com.company.Crafting.Weapons.*;
import com.company.GameValues;
import com.company.ImageBank;
import com.company.Items.Item;
import com.company.Items.Swords.IronSword;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

;

public class CraftingPane extends ScrollPane {

    private final double PREF_WIDTH = 250;
    private final double PREF_HEIGHT = 200;


    // inner class : single crafting recipe pane
    private class CraftingRecipePane extends Pane{


        private void buildPaneContents(CraftingRecipe craftingRecipe){

            try{

                // Craftable item image
                Item tempItem = craftingRecipe.getCraftedItemClass().newInstance();
                ImageView craftableItemImageView = tempItem.buildImageView();
                craftableItemImageView.setFitHeight(22);
                craftableItemImageView.setFitWidth(22);
                craftableItemImageView.relocate(5,5);

                getChildren().add(craftableItemImageView);

                // Arrow indicator
                Text arrow = new Text("<");
                arrow.relocate(35, 8);

                getChildren().add(arrow);

                // Requirements
                int xRootForReqObject = 50;

                // // Required items
                for(Class<? extends Item> itemClass : craftingRecipe.getRequiredItems()){
                    Item tempReqItem = itemClass.newInstance();
                    ImageView reqItemImageView = tempReqItem.buildImageView();
                    reqItemImageView.setFitWidth(22);
                    reqItemImageView.setFitHeight(22);
                    reqItemImageView.relocate(xRootForReqObject, 5);
                    getChildren().add(reqItemImageView);
                    xRootForReqObject += 25;
                }

                // // Required resources
                for(int i = 0; i < craftingRecipe.getRequiredResources().length; i++){
                    if(craftingRecipe.getRequiredResources()[i] > 0){

                        // Image
                        ImageView reqResImageView = new ImageView();
                        reqResImageView.setImage(ImageBank.getResourceIcons());
                        reqResImageView.setViewport(new Rectangle2D(2+i*9,2,6.5,6.5));
                        reqResImageView.setFitHeight(10);
                        reqResImageView.setFitWidth(10);
                        reqResImageView.relocate(xRootForReqObject+2, 5);
                        getChildren().add(reqResImageView);

                        // Amount
                        Text amount = new Text(""+craftingRecipe.getRequiredResources()[i]);
                        amount.relocate(xRootForReqObject, 14);
                        getChildren().add(amount);

                        xRootForReqObject += 20;

                    }
                }


            }catch (Exception e){

            }
        }


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

            buildPaneContents(craftingRecipe);


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
            // color recreated manually because of scroll-pane opacity issues
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
        addRecipesToDisplay(
                new Recipe_CopperDrill(),
                new Recipe_IronDrill(),
                new Recipe_CobaltDrill(),
                new Recipe_BloodRubyDrill(),
                new Recipe_Trowel(),
                new Recipe_CopperSpear(),
                new Recipe_IronSpear(),
                new Recipe_CobaltSpear(),
                new Recipe_BloodRubySpear(),
                new Recipe_CopperDagger(),
                new Recipe_IronDagger(),
                new Recipe_CobaltDagger(),
                new Recipe_BloodRubyDagger(),
                new Recipe_CopperSword(),
                new Recipe_IronSword(),
                new Recipe_CobaltSword(),
                new Recipe_BloodRubySword()
        );

    }
}
