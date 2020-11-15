package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.util.Random;

public class Ii {

    private Enemy[]         enemy;
    private int             count = 0;
    private TextureAtlas    atlas;
    private Random          random = new Random();

    Ii(TextureAtlas atlas){

        this.atlas  = atlas;
        enemy       = new Enemy[Const.ENEMY_NUM_MAX];

        for(int i = 0; i < Const.ENEMY_NUM_MAX; i ++){
            enemy[i] = new Enemy(atlas.cut(8, 108, 18, 18));
        }
    }

    public void update(){
        count ++;
        for(int i = 0; i < Const.ENEMY_NUM_MAX; i ++){
            enemy[i].update();
        }
        if(count > 30){add(); count = 0;}
    }

    public void add(){

            for (int i = 0; i < Const.ENEMY_NUM_MAX; i++) {
                if (!enemy[i].getActiv()) {

                    enemy[i].setActiv(true);
                    enemy[i].setX(random.nextInt(Const.FRAME_WIDTH - 20));
                    enemy[i].setImage(atlas.cut(8, 108, 18, 18));
                    enemy[i].setLevel(1);
                   // enemy[i].setSpeed(Const.ENEMY_SPEED_1);
                    break;
                }
            }
    }

    public void render(Graphics2D g){

        for(int i = 0; i < Const.ENEMY_NUM_MAX; i ++){
            if(enemy[i].getActiv()){
                enemy[i].render(g);
            }
        }
    }
}
