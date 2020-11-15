package net.kiranatos.youtube.g12platf;

import java.awt.event.*;

public class Listeners implements KeyListener , MouseListener , MouseMotionListener {

    GameBack gameBack = new GameBack();
    Player player = new Player();

    public static boolean playClick = false;
    public static boolean settingsClick = false;
    public static boolean settingsCross = false;
    public static boolean boardCross = false;
    public static boolean patreonClick = false;
    public static boolean onAudio = false;
    public static boolean offAudio = false;

    @Override
    public void keyTyped(KeyEvent e) {
        double key = e.getKeyCode();// получить код нажатой клавиши
    }

    @Override
    public void keyPressed(KeyEvent e) {
        double key = e.getKeyCode();// получить код нажатой клавиши
        double key1 = e.getKeyCode();// получить код нажатой клавиши

        if (key == KeyEvent.VK_W){
            player.Fly1 = true;
        }

        if (key1 == KeyEvent.VK_S){
            player.Fly2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        double key = e.getKeyCode();// получить код нажатой клавиши
        double key1 = e.getKeyCode();// получить код нажатой клавиши

        if (key == KeyEvent.VK_W){
            player.Fly1 = false;
        }

        if (key1 == KeyEvent.VK_S){
            player.Fly2 = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {   }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUE) {
                playClick = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUE) {
                patreonClick = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.PLAY) {
                boardCross = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.SETTINGS) {
                onAudio = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.SETTINGS) {
                offAudio = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUE) {
                settingsClick = true;
            }
        }

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.SETTINGS) {
                settingsCross = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        settingsClick = false;
        settingsCross = false;
        playClick = false;
        boardCross = false;
        patreonClick = false;
        offAudio = false;
        onAudio = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Panel.mouseX = e.getX();//
        Panel.mouseY = e.getY();//
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();//
        Panel.mouseY = e.getY();//
    }
}
