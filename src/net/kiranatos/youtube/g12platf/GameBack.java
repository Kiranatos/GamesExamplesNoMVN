package net.kiranatos.youtube.g12platf;

//import com.sun.prism.Texture;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Long.valueOf;

public class GameBack {

    public static boolean GameOver = false; // если Проиграшь

    static int XMove;
    static int XMove1 = 1500;
    static int YMove;

    static Image back = new ImageIcon(Paths.BACKGROUND).getImage();
    static Image back1 = new ImageIcon(Paths.BACKGROUND).getImage();

    Image addres []  = { back,back1} ;

    public void GameDraw(Graphics2D g) {
        g.drawImage(addres[0], GameBack.XMove, GameBack.YMove,null);
        g.drawImage(addres[1], GameBack.XMove1, GameBack.YMove,null);
    }
    
    static int speed = 20;

    public void update() { // Движение картинки
        if (Let.Plus3 == false) {
            XMove -= speed;
            XMove1 -= speed;
            if (XMove == -1500) {
                XMove = 0;
            }
            if (XMove1 == 0) {
                XMove1 = 1500;
            }
        }
    }
}