package net.kiranatos.youtube.g11galaxian;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {

    public static final String PATH = "res/";

    public static BufferedImage loadImage(InputStream fileName){

        BufferedImage image = null;

        try{
            image = ImageIO.read(fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
