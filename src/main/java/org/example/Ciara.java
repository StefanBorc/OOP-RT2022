package org.example;

import java.awt.*;

public class Ciara {
    private int dlzka;
    private Color farba;
    private int xZ;
    private int yZ;
    private int xK;
    private int yK;
    public Ciara(int dlzka, Color farba,int xZ,int yZ,int xK,int yK){
        this.farba=farba;
        this.dlzka=dlzka;
        this.xZ=xZ;
        this.yZ=yZ;
        this.yK=yK;
        this.xK=xK;

    }
    protected void nakresliCiaru(Graphics g){
        g.setColor(farba);
        g.drawLine(xZ,yZ,xK,yK);
    }

}
