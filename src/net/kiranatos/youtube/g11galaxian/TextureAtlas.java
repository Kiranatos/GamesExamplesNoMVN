package net.kiranatos.youtube.g11galaxian;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class TextureAtlas {

    BufferedImage image;

    TextureAtlas(InputStream imageName){
        image = ResourceLoader.loadImage(imageName);
    }

    public BufferedImage cut(int x, int y, int width, int height){
        return image.getSubimage(x, y, width, height);
    }
}
