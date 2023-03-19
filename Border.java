package com.company;


public class Border extends GameObject{


    public int getPosX() {
        return posX;
    }

    public Border(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void SetSize() {

    }

    @Override
    protected void SetPosition() {

    }
}
