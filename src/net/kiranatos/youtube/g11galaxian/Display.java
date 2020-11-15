package net.kiranatos.youtube.g11galaxian;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Display{

    private static JFrame frame;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int bufferData[];
    private static Graphics bufferGraphics;
    private static BufferStrategy bufferStrategy;

    private static int clearColor;

    Display(int width, int height, String title, int _clearColor, int numBuffer){

        content = new Canvas();
        content.setPreferredSize(new Dimension(width, height));

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(width, height);
        frame.setResizable(false);
        frame.getContentPane().add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        ((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        content.createBufferStrategy(numBuffer);//создает  numBuffer буферов для обмена
        bufferStrategy = content.getBufferStrategy();

        clearColor = _clearColor;
    }

    public static void clear(){

        Arrays.fill(bufferData, clearColor);
    }

    public static void swapBuffers(){

        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer, 0, 0, null);
        bufferStrategy.show();
    }

    public static void destroy(){
        frame.dispose();
    }

    public static void setTitle(String title){
        frame.setTitle(title);
    }

    public static void addInputListener(Input inputListener){
        frame.add(inputListener);
    }

    public static Graphics2D getGraphics(){
        return (Graphics2D)bufferGraphics;
    }
}
