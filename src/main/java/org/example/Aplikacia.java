package org.example;

import javax.swing.*;
import java.awt.*;

public class Aplikacia{

    public Aplikacia(){
        JFrame aplikacia=new JFrame("Korytnacka");
        aplikacia.setSize(700,700);
        aplikacia.setResizable(false);
        aplikacia.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Korytnacka korytnacka=new Korytnacka(45,10,Color.GREEN);

        JLabel zvolenaFarba=new JLabel("Farba : Zelena");
        JLabel zvolenyKrokUhol=new JLabel("krok : 10 uhol : 45");

        Priebeh priebeh=new Priebeh(aplikacia,korytnacka,zvolenaFarba,zvolenyKrokUhol);

        Integer[] uhly=new Integer[]{0,5,10,45,90,180};
        JComboBox uhol=new JComboBox(uhly);
        uhol.setFocusable(false);
        uhol.setSelectedItem(uhly[3]);
        uhol.addItemListener(priebeh);

        JSlider krok=new JSlider(0,100,10);
        krok.setFocusable(false);
        krok.setMinorTickSpacing(10);
        krok.setMajorTickSpacing(10);
        krok.setSnapToTicks(true);
        krok.setPaintTicks(true);
        krok.setPaintLabels(true);

        krok.addChangeListener(priebeh);

        JButton akcia=new JButton("Akcia");
        akcia.addActionListener(priebeh);

        JButton farba=new JButton("Zmena farby");
        farba.addActionListener(priebeh);

        JPanel menu=new JPanel();

        menu.add(uhol);
        menu.add(krok);
        menu.add(akcia);
        menu.add(zvolenyKrokUhol);
        menu.add(farba);
        menu.add(zvolenaFarba);

        farba.setFocusable(false);
        akcia.setFocusable(false);

        aplikacia.add(menu, BorderLayout.SOUTH);
        aplikacia.add(korytnacka,BorderLayout.CENTER);

        aplikacia.setFocusable(false);
        aplikacia.setVisible(true);
    }
}
