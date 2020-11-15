package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import java.awt.*;

public class Settings {
    Listeners listeners = new Listeners();
    Audio audio = new Audio(Paths.SOUND_PLAY,20);
    static ButtMenue onAudio = new ButtMenue(100,100,180,100,Paths.MENU_AUDIO,"Старт");
    static ButtMenue offAudio = new ButtMenue(100,300,180,100,Paths.MENU_C_AUDIO,"Старт");

    public void onAudioSettingsUpdate(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            onAudio.s = Paths.MENU_AUDIO;
            if (listeners.onAudio == true) {
                Panel.a_play.play();
            }
        }
        else {
            onAudio.s = Paths.MENU_AUDIO;
        }
    }

    public void offAudioSettingsUpdate(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            offAudio.s = Paths.MENU_C_AUDIO;
            if (listeners.offAudio == true) {
                Panel.a_play.stop();
            }
        }
        else {
            offAudio.s = Paths.MENU_C_AUDIO;
        }
    }
    
    static class ButtMenue {
        private double x;
        private double y;
        private double w;
        private double h;

        public Color color1;

        public String f; // Надпись на кнопке
        public String s; // адресс картинки

        public ButtMenue(int x, int y, int w, int h, String s, String f ) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            color1 = Color.WHITE;
        }

        public void drawBut(Graphics2D g) {
            g.drawImage(new ImageIcon(String.valueOf(s)).getImage(), (int)x , (int)y, null );
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
}