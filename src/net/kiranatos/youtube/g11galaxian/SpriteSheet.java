package net.kiranatos.youtube.g11galaxian;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage   sheet;
    private int             spriteCount;
    private int             scale;
    private int             spriteInWidth;

    SpriteSheet(BufferedImage sheet, int spriteCount, int scale){

        this.sheet          = sheet;
        this.spriteCount    = spriteCount;
        this.scale          = scale;

        this.spriteInWidth = sheet.getWidth() / scale;
    }

    public BufferedImage getSprite(int index){

        index = index % spriteCount;
        int x = index % spriteInWidth * scale;
        int y = index / spriteInWidth * scale;
        //System.out.println(index + " | " + x + " | " + y);
        return sheet.getSubimage(x, y, scale, scale);
    }
}
