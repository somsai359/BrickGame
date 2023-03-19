package com.company;

import javax.swing.*;
import java.awt.*;

public class Player extends  GameObject{

    private  int score;
    private int move;
    private int limitRightMove;
    private int limitLeftMove;
    private JFrame obj;

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Player(JFrame obj)
    {
        this.obj=obj;
        DisplayWidthOnePercent=obj.getWidth()/100;
        DisplayHeightOnePercent=obj.getWidth()/100;
        Reset();
        setSpeedMove();

        SetSize();
        SetWallLimitMove();
    }

    public int getScore() {
        return score;
    }
    public void AddPoint()
    {
        score++;
    }
    public int getPosX() {
        return posX;
    }

    public void Reset()
    {
        SetPosition();
        score=0;
    }
    public void TurnLeft()
    {
        posX-=move;
    }
    public void TurnRight()
    {
        posX+=move;
    }

    public void Draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(posX, posY, width, height);
    }
    public  boolean IsTouchingRightWall()
    {
        return posX>=limitRightMove;
    }
    public  boolean IsTouchingLeftWall()
    {
        return posX<=limitLeftMove;
    }
    public void BlockRightMove()
    {
        posX=limitRightMove;
    }
    public void BlockLeftMove() {
        posX=limitLeftMove;
    }
    private  void setSpeedMove()
    {
        move=20;
    }
    private void SetWallLimitMove()
    {
        limitRightMove=obj.getWidth()-(DisplayWidthOnePercent*18);
        limitLeftMove=0;
    }
    @Override
    protected void SetSize() {
        width =obj.getWidth()/6;
        height =DisplayHeightOnePercent;
    }

    @Override
    protected void SetPosition() {
        posX =DisplayWidthOnePercent*50;
        posY =DisplayHeightOnePercent*90;
    }

}
