package com.company;

import java.awt.*;

public class BackGround extends GameObject{


    @Override
    protected void SetSize() {

    }

    @Override
    protected void SetPosition() {

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

    public BackGround(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void Draw(Graphics g, Map map)
    {
        g.setColor(Color.BLACK);
        g.fillRect(map.getBackGround().getPosX(), map.getBackGround().getPosY(), map.getBackGround().getWidth(), map.getBackGround().getHeight());
    }
}
