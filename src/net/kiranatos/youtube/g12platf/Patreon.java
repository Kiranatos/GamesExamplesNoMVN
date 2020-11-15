package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Patreon {
    static ButtMenue patreon = new ButtMenue(700,340,100,100,Paths.MENU_PATREON,"Выход");

    Listeners listeners = new Listeners();

    public void patreonUpdate(ButtMenue e) {
        if (Panel.mouseX > e.getX() && Panel.mouseX < e.getX() + e.getW() &&
                Panel.mouseY > e.getY() && Panel.mouseY < e.getY() + e.getH()) {
            
            patreon.s = Paths.MENU_C_PATREON;

            if (listeners.patreonClick == true) {
                String link = "https://www.patreon.com/NeITProG";

                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop desk = Desktop.getDesktop();
                        desk.browse(new URI(link));
                    } catch (URISyntaxException | IOException f) {
                        f.printStackTrace();
                    }
                }
            }
        } else {
            patreon.s = Paths.MENU_PATREON;
        }
    }

    static class ButtMenue {
        public String s2;
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
