package com.company.Resources;

public class Resource {

    private int amount;
    public int getAmount() {
        return amount;
    }

    public void gain(int amount){
        this.amount += amount;
    }

    public void lose(int amount){
        this.amount -= amount;
    }

    public boolean isEnough(int amountNeeded){
        return amountNeeded <= amount;
    }

    public Resource(){
        amount = 0;
    }
    public Resource(int initAmount){
        amount = initAmount;
    }
}
