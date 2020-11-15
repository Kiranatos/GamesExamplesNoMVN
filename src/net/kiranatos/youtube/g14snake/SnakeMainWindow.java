package net.kiranatos.youtube.g14snake;

/*
Основа из
Ирина Галкина : https://www.youtube.com/channel/UCpp4x4-fLtPpLf3lPN5ga4Q/videos
https://github.com/irinamore
Программирование на Java: создание игры Змейка. Часть 1-3.
*/

/*
Переделать и доделать. Можно создать игру для изучения англ/японс.
*/

import javax.swing.*;

public class SnakeMainWindow extends JFrame {

    public SnakeMainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320,345);
        setLocation(400,400);
        add(new GameField());
        setVisible(true);
        setAlwaysOnTop(true);        
    }

    public static void main(String[] args) {
        SnakeMainWindow mw = new SnakeMainWindow();
    }
}