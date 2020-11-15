package net.kiranatos.youtube.g12platf;

//import com.sun.org.apache.xpath.internal.operations.Plus;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;

/**
 * меню игры
 */
public class Let {
    GameBack gameBack = new GameBack();
    
    BoxM box1= new BoxM(Xbox1,Ybox1,80,80,Paths.BOX,"");
    BoxM box2= new BoxM(Xbox2,Ybox2,80,80,Paths.BOX,"");
    BoxM box3= new BoxM(Xbox3,Ybox3,80,80,Paths.BOX,"");
    BoxM box4= new BoxM(Xbox4,Ybox4,80,80,Paths.BOX,"");

    public static int Xbox1;
    public static int Ybox1 = 100;
    public static int Xbox2;
    public static int Ybox2 = 340;
    public static int Xbox3;
    public static int Ybox3 = 420;
    public static int Ybox4 = 240;
    public static int Xbox4;
    public static int speed = 20;

    public static int scoreX = 1; // счет для прибовления
    public static int score = 0; // сцет
    public static int scoreY = 1; // амплетуда прибовления

    private boolean  collision ;

    public static boolean B1 = false; // Коробка 1
    public static boolean B2 = false; // Коробка 2
    public static boolean B3 = false; // Коробка 3
    public static boolean B4 = false; // Коробка 3


    public static boolean Plus1 = false; // цикл движения коробок
    public static boolean Plus2 = false; // цикл увелечения
    public static boolean Plus3 = false; // и еще какойто цикл


     private static boolean drawBox1 = false; // Коробка 1
     private static boolean drawBox3 = false; // Коробка 3
     private static boolean drawBox4 = false; // Коробка 4

    private static String Num = " СЧЕТ";
    private static String Version = "Run aNd Run (RAR) v.0.0.1 ;;; СДЕЛАНО Птеренко Дмитрием ";

    private int min = 1;
    private int max = 6;

    Random random = new Random();

    int res = max - min;

    int b = random.nextInt(res + 1);

    public Color color1= Color.WHITE;

    public static boolean click = true;

    static Image boxImage1 = new ImageIcon(Paths.BOX).getImage();
    static Image boxImage2 = new ImageIcon(Paths.BOX).getImage();
    static Image boxImage3 = new ImageIcon(Paths.BOX).getImage();
    static Image boxImage4 = new ImageIcon(Paths.BOX).getImage();


    public void drawBox(Graphics2D g) {
        //box1.draw1(g);
        //box3.draw3(g);
       // box4.draw4(g);
        g.drawImage(boxImage1,Xbox1 ,Ybox1,null);
        g.drawImage(boxImage3,Xbox3 ,Ybox3,null);
        g.drawImage(boxImage4,Xbox4 ,Ybox4,null);
    }


    public void BoxUpdate(){
        if(Plus1 == false) {
            Xbox1 -= speed;
            Xbox2 -= speed;
            Xbox3 -= speed;
            Xbox4 -= speed;
            score++;
        }

        if(Plus2 == false) {
            if (B1 == false) {  // Условие если B1 or B2 or B3 равно false рандомится число
                int r = random.nextInt(res + 1);
                if (r == 1) {
                    drawBox1 = true;
                    Xbox1 = 1900;
                    B1 = true;
                }
            }
            if (Xbox1 == 0) {
                B1 = false;
                Xbox1 = 1900;
            }

            if (B3 == false) {  // Условие если B1 or B2 or B3 равно false рандомится число
                int r2 = random.nextInt(res + 1);
                if (r2 == 2) {
                    drawBox3 = true;
                    Xbox3 = 1200;
                    B3 = true;
                }
            }

            if (Xbox3 == 0) {
                B3 = false;
                Xbox3 = 1200;
            }

            if (B4 == false) {  // Условие если B1 or B2 or B3 равно false рандомится число
                int r4 = random.nextInt(res + 1);
                if (r4 == 4) {
                    drawBox4 = true;
                    Xbox4 = 1500;
                    B4 = true;
                }
            }
            if (Xbox4 == 0) {
                B4 = false;
                Xbox4 = 1500;
            }
        }

        if(gameBack.GameOver == true){
            Plus1 = true;
            Plus2 = true;
            Plus3 = true;
        }
    }

    public Rectangle getRect1() { // получение прямоугоьников
        return new Rectangle(Xbox1,Ybox1, 80, 80); //возвращаем конструктор с размером объекта
    }
    public Rectangle getRect2() { // получение прямоугоьников
        return new Rectangle(Xbox3,Ybox3, 80, 80); //возвращаем конструктор с размером объекта
    }
    public Rectangle getRect3() { // получение прямоугоьников
        return new Rectangle(Xbox4,Ybox4, 80, 80); //возвращаем конструктор с размером объекта
    }

    static class BoxM {
        public String s2;
        private double x;
        private double y;
        private double w = 80;
        private double h = 80;
        public Color color1;
        public String f; // Надпись на кнопке
        public String s; // адресс картинки

       public BoxM(int x, int y, int w, int h, String s, String f) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            color1 = Color.RED;
}
        public double getX() {
            return x;
        }

        public double getY() { return y; }

        public double getW() {
            return w;
        }

        public double getH() {
            return h;
        }
    }
    public void Y1Draw (Graphics2D g){
        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.ITALIC,60);
        g.setFont(font);
        g.drawString(String.valueOf(score + Num),(int)10,(int)130);
    }

    public void VersionDraw (Graphics2D g){
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC,20);
        g.setFont(font);
        g.drawString(String.valueOf(Version),(int)10,(int)650);
    }

}

