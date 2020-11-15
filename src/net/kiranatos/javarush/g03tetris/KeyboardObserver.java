package net.kiranatos.javarush.g03tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver extends Thread
{
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    private JFrame frame;

    @Override
    public void run()
    {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);// при true - уберается рамка окна со "закрыть, свернуть, развернуть"
        //setUndecorated нужно вызывать до pack(). Иначе там создаются peer-объекты, а после их создания setUndecorated уже не вызвать.
        
        frame.setSize(400, 400);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //максимальный размер
        frame.setLayout(new GridBagLayout());

        //frame.setOpacity(0.3f); //заливка 0
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                System.out.println("Фокусировка невидимого окна возвращена!");
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                System.out.println("Фокусировка невидимого окна потеряна! Игра остановлена !");
                System.exit(0);
            }
        });


        frame.addKeyListener(new KeyListener()
        {

            public void keyTyped(KeyEvent e)
            {
                System.out.println("keyTyped");
                //do nothing
            }

            public void keyReleased(KeyEvent e)
            {
                System.out.println("keyReleased");
                //do nothing
            }

            public void keyPressed(KeyEvent e)
            {
                System.out.println("keyPressed");
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents()
    {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop()
    {
        return keyEvents.poll(); //возвращает вершину стека Queue событий
    }
}
