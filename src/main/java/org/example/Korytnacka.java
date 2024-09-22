package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Korytnacka extends JPanel {
    private ArrayList<Ciara> ciary;
    @Getter
    private int xTela;
    @Getter
    private int yTela;
    private int xHlavy;
    private int yHlavy;
    @Getter
    @Setter
    private int uhol;
    @Getter
    @Setter
    private int krok;
    @Setter
    private Color farba;

    public Korytnacka(int uhol, int krok, Color farba) {
        xTela = 350;
        yTela = 250;
        this.krok = krok;
        this.uhol = uhol;
        this.farba = farba;
        xHlavy = 350 - 10;
        yHlavy = 250 - 35;
        ciary = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        otocKorytnacku();
        for (Ciara ciara : ciary) {
            ciara.nakresliCiaru(g);
        }
        nakresliKorytnacku(g);
    }

    private void nakresliKorytnacku(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(xTela - 25, yTela - 25, 50, 50);
        g.setColor(Color.GRAY);
        g.fillOval(xHlavy - 10, yHlavy - 10, 20, 20);
    }

    protected void otocKorytnacku() {
        xHlavy = (int) (xTela + 20 * Math.cos(Math.toRadians(uhol)));
        yHlavy = (int) (yTela + 20 * Math.sin(Math.toRadians(uhol)));
    }

    protected void posunKorytnacku() {
        xTela = (int) (xTela + krok * Math.cos(Math.toRadians(uhol)));
        yTela = (int) (yTela + krok * Math.sin(Math.toRadians(uhol)));
    }

    protected void pridajCiaru(int stareX, int stareY) {
        ciary.add(new Ciara(krok, farba, stareX, stareY, xTela, yTela));
    }
}

