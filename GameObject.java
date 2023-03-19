package com.company;


public abstract class GameObject {

    protected  int posX;
    protected  int posY;
    protected  int width;
    protected  int height;
    protected int DisplayWidthOnePercent;
    protected int DisplayHeightOnePercent;

    protected abstract void SetSize();
    protected abstract void SetPosition();

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
