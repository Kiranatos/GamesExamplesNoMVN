package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard {

    private String adress;

    GameBack gameBack = new GameBack();
    Let let = new Let();

    private int Oldrecord = 0 ;
    private int Newrecord = 0;

    private int i = 0;
    private int[] record = {0,1,2,3,4,5};

    private ArrayList <String> gameOv = new ArrayList<>();

    private int gameAnim; // перечеслоения онимации в доске луза

    private static Image loseBoard = new ImageIcon(Paths.GAME_OVER).getImage();

    public GameBoard(){

        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);
        gameOv.add(Paths.GAME_OVER);

        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
        gameOv.add("gameOver");
    }

    public void overUpdate() {
        gameAnim++;
        if (gameAnim >= gameOv.size()) gameAnim = 0;
        adress = gameOv.get(gameAnim);

        if (record[0] < let.score) {
            record[1] = let.score;
            i = 1;
        }
        if (record[1] < let.score) {
            record[2] = let.score;
            i = 2;
        }
    }

    public void boardDraw(Graphics2D g){
        g.drawImage(loseBoard,(int)250,(int)150,null);
    }

    public void boradsDraw(Graphics2D g){
        g.drawImage(new ImageIcon(adress).getImage(),(int)273,(int)148,null);
    }

    public void scoreDraw (Graphics2D g){
        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.ITALIC,60);
        g.setFont(font);
        g.drawString(String.valueOf(let.score),(int)290,(int)330);
    }
    public void recordDraw (Graphics2D g){
        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.ITALIC,60);
        g.setFont(font);
        g.drawString(String.valueOf(record[i]),(int)590,(int)330);
    }
}
