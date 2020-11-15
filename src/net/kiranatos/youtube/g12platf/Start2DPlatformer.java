package net.kiranatos.youtube.g12platf;

/*
YouTube channel: NeIT https://www.youtube.com/channel/UChnq246zZw47suB0P5aJx-g
*/

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Start2DPlatformer {

    int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3);
    int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 5);


    public static void main (String [] args){
        JFrame startFrame = new JFrame("Identity ME");

        int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3);
        int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 5);

        Panel panel = new Panel();

        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// закрытие окна при клике крестика
        startFrame.setContentPane(panel); // перенос в фрейм панели с GamePanel
        //startFrame.add(panel);
        startFrame.setLocationRelativeTo(null);//полоение фрейма по центру
        startFrame.pack();//размер фрейма как и размер его компонентов
        startFrame.setLocation(centerX,centerY);

        panel.myStart();// заускаем поток панели

        startFrame.add(new Panel());
        startFrame.setVisible(true);
        startFrame.setSize(1000,720);
    }
}
