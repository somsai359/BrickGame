package com.company;

import javax.swing.*;

public class Map {

    private  Border borderLeft;
    private  Border borderUp;
    private  Border borderRight;

    private BackGround backGround;

    public BackGround getBackGround() {
        return backGround;
    }

    public Border getBorderRight() {
        return borderRight;
    }

    public  Map(JFrame obj)
    {
        int DisplayWidthOnePercent=obj.getWidth()/100;

        borderLeft= new Border(0, 0, DisplayWidthOnePercent/2, obj.getHeight());
        borderUp= new Border(0, 0, obj.getWidth(), DisplayWidthOnePercent/2);
        borderRight= new Border(obj.getWidth()-30, 0, DisplayWidthOnePercent/2, obj.getHeight());
        backGround= new BackGround(0, 0, obj.getWidth(), obj.getHeight());
    }
}
