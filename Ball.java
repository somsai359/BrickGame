package com.company;

import javax.swing.*;
import java.awt.*;

public class Ball extends GameObject{

    private int XDir;
    private int YDir;
    private int escape;
    private  JFrame obj;

    public void Draw(Graphics g) {

        g.setColor(Color.RED);
        g.fillOval(posX, posY, width, height);
    }
    @Override
    protected void SetSize()
    {
        width =(obj.getWidth()/100)*3;
        height =(obj.getHeight()/100)*3;
    }

    @Override
    protected void SetPosition() {
        posX=obj.getWidth()/2;
        posY=obj.getHeight()/2;
    }

    private void SetEscape()
    {
        escape =obj.getHeight();
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

    public Ball(JFrame obj)
    {
        this.obj=obj;
        Reset();
        SetSize();
        SetEscape();
    }
    public void Stop()
    {
        XDir =0;
        YDir=0;
    }
    public void Move()
    {
        posX += XDir;
        posY += YDir;
    }
    public void Reset()
    {
        SetPosition();
        XDir=-1;
        YDir=-2;
    }
    private boolean BallPosXTouchLeftWall()
    {
        return  posX < 0;
    }
    public void MoveDirX()
    {
        if(BallPosXTouchLeftWall())
            XDir = -XDir;
    }
    private boolean BallPosYTouchLeftWall()
    {
        return  posY < 0;
    }
    public void MoveDirY()
    {
        if(BallPosYTouchLeftWall())
            YDir = -YDir;
    }

    public void XDirReverse()
    {
        XDir = -XDir;
    }
    public void YDirReverse()
    {
        YDir=-YDir;
    }
    public boolean Escape()
    {
        return posY > escape;
    }
}
