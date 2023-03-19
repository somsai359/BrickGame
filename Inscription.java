package com.company;

import javax.swing.*;
import java.awt.*;

public class Inscription extends GameObject{

    private int size;

    public int getSize() {
        return size;
    }

    @Override
    protected void SetSize() {

    }

    @Override
    protected void SetPosition() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private String text;

    public Inscription(String text, JFrame obj, int displayWidthPercent,int displayHeightPercent)
    {
        size=30;
        DisplayWidthOnePercent=obj.getWidth()/100;
        DisplayHeightOnePercent=obj.getHeight()/100;
        width=DisplayWidthOnePercent*displayWidthPercent;
        height=DisplayHeightOnePercent*displayHeightPercent;
        this.text=text;
    }
    public  void Draw(Graphics g, Player player)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, size));
        g.drawString(text+player.getScore(), width, height);
    }

    public String getText() {
        return text;
    }
}
