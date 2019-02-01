package com.company.Items;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract public class Item {

    // Item's name
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // Item's image
    private Image image;
    private int viewPortRow;
    private int viewPortCol;

    protected void setImage(Image image, int row, int col){
        this.image = image;
        viewPortRow = row;
        viewPortCol = col;
    }

    public ImageView buildImageView(){
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView. setViewport(new Rectangle2D(2 + viewPortCol*17, 2 + viewPortRow*17, 14,14));
        return imageView;
    }


}

