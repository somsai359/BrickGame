package com.company;

import javax.swing.*;
import java.awt.*;

public class MapGenerator {
    public int map[][];
    public Brick brick;

    private  int spacing;

    public MapGenerator(int row, int col, JFrame obj)
    {
        spacing=3;
        map= new int [row][col];
        brick= new Brick(obj);
        Init();
        brick.setWidth((obj.getWidth()/2 + obj.getWidth()/5)/col);
        brick.setHeight((obj.getHeight()/4)/row);
    }
    private  void Init()
    {
        for(int a=0;a<map.length;a++) {
            for (int b = 0; b < map[0].length; b++)
                map[a][b] = 1;
        }
    }
    public void draw(Graphics2D g)
    {
        for(int a=0;a<map.length;a++) {
            for (int b = 0; b < map[0].length; b++)
                if(map[a][b]>0)
                {
                    g.setColor(Color.yellow.WHITE);
                    g.fillRect(b*brick.getWidth()+brick.border.getWidth(), a*brick.getHeight()+brick.border.getHeight(), brick.getWidth(), brick.getHeight());

                    g.setStroke(new BasicStroke(spacing));
                    g.setColor(Color.BLACK);
                    g.drawRect(b*brick.getWidth()+brick.border.getWidth(), a*brick.getHeight()+brick.border.getHeight(), brick.getWidth(), brick.getHeight());
                }
        }
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col]=value;
    }
}
