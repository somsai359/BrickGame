package com.company;

import javax.swing.*;

public class Main {

    private static int objBorderPosX=0;
    private static int objBorderPosY=0;
    private static int objBorderWidth=600;
    private static int objBorderHeight=600;

    public static void main(String[] args) {

        JFrame obj= new JFrame();
        obj.setBounds(objBorderPosX, objBorderPosY, objBorderWidth, objBorderHeight);
        Game game= new Game(obj);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);
    }
}
