package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Priebeh extends UniverzalnyAdapter{
    public static final String AKCIA="Akcia";
    private JFrame aplikacia;
    private Korytnacka korytnacka;
    private ArrayList<Color> farby;
    private Color zvolenaFarba;
    private int uholKorytnacky;
    private JLabel farbaLablu;
    private JLabel krokUhol;

    public Priebeh(JFrame aplikacia,Korytnacka korytnacka,JLabel farbaLablu,JLabel velkostKrokUhol) {
        this.aplikacia = aplikacia;
        this.korytnacka = korytnacka;
        korytnacka.addKeyListener(this);
        korytnacka.setFocusable(true);
        this.uholKorytnacky = 45;
        this.farbaLablu=farbaLablu;
        this.krokUhol=velkostKrokUhol;
        zvolenaFarba = Color.GREEN;
        inicializujFarby();
    }
    private void inicializujFarby(){
        farby=new ArrayList<>();
        farby.add(Color.GREEN);
        farby.add(Color.BLACK);
        farby.add(Color.RED);
        zvolenaFarba=farby.get(0);
    }
    private void zmenFarbu(){
        farby.add(farby.get(0));
        farby.remove(0);
        zvolenaFarba=farby.get(0);
        String nazovFarby;
        if(zvolenaFarba.equals(Color.GREEN)){
            nazovFarby="Zelena";
        }
        else if(zvolenaFarba.equals(Color.RED)){
            nazovFarby="Cervena";
        }
        else{
            nazovFarby="Cierna";
        }
        farbaLablu.setText("Farba : "+nazovFarby);
    }
    private void zmenVelkosti(){
        krokUhol.setText("Krok : "+korytnacka.getKrok()+" Uhol : "+uholKorytnacky);
    }
    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getActionCommand().equals(AKCIA)){
            var stareX=korytnacka.getXTela();
            var stareY=korytnacka.getYTela();
            korytnacka.posunKorytnacku();
            korytnacka.setUhol(korytnacka.getUhol()+uholKorytnacky);
            korytnacka.pridajCiaru(stareX,stareY);
       }
       else{
            zmenFarbu();
            korytnacka.setFarba(zvolenaFarba);
       }
       korytnacka.repaint();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        uholKorytnacky= (int)e.getItem();
        zmenVelkosti();
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        korytnacka.setKrok(((JSlider)e.getSource()).getValue());
        zmenVelkosti();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        var stareX=korytnacka.getXTela();
        var stareY=korytnacka.getYTela();
        if(e.getKeyCode()==KeyEvent.VK_UP){
           korytnacka.posunKorytnacku();
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            korytnacka.setKrok(-korytnacka.getKrok());
            korytnacka.posunKorytnacku();
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            korytnacka.setUhol(korytnacka.getUhol()+uholKorytnacky);
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            korytnacka.setUhol(korytnacka.getUhol()-uholKorytnacky);

        }
        korytnacka.pridajCiaru(stareX,stareY);
        korytnacka.setKrok(Math.abs(korytnacka.getKrok()));
        korytnacka.repaint();
    }

}
