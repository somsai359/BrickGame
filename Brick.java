package com.company;

import javax.swing.*;

public class Brick extends GameObject{

    public Border border;
    private  JFrame obj;

    @Override
    protected void SetSize() {
        width=obj.getWidth();
        height=obj.getHeight()/4;
    }

    @Override
    protected void SetPosition() {
        posX = DisplayWidthOnePercent*13;
        posY = DisplayHeightOnePercent*9;
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }

    public Brick(JFrame obj) {
        this.obj=obj;
        DisplayWidthOnePercent=obj.getWidth()/100;
        DisplayHeightOnePercent=obj.getHeight()/100;
        SetSize();
        SetPosition();
        border= new Border(0, 0, DisplayWidthOnePercent*13, DisplayHeightOnePercent*9);
    }
}
