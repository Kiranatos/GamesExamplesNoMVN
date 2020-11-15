package net.kiranatos.youtube.g11galaxian;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Engine implements Runnable{

    private boolean         running;
    private Thread          engineThread;
    private Display         display;
    private Graphics2D      graphics;
    private Input           input;
    private TextureAtlas    atlas;
    private SpriteSheet     sheet;
    private Sprite          sprite;
    private Bullet[]        bullet;
    private Enemy[]         enemy;
    private Explosion[]     explosion;

    private Random          random      = new Random();
    private int             bulletCount = 29;
    private int             enemyCount  = 29;

    //temp
    private float   d       = 0;
    private int     step    = 5;
    private int     x       = 375;
    private int     y       = 275;
    //temp end
    Engine(){
        running = false;
        display = new Display(Const.FRAME_WIDTH, Const.FRAME_HEIGHT, Const.FRAME_TITLE,
                                                            Const.CLEAR_COLOR, Const.NUM_BUFFER);
        graphics    = display.getGraphics();
        input       = new Input();
        display.addInputListener(input);

        atlas   = new TextureAtlas(Const.ATLAS_FILE_NAME);
        sheet   = new SpriteSheet(atlas.cut(31, 61, 18, 36), 1, 18);
        sprite  = new Sprite(sheet, 2);
        bullet  = new Bullet[Const.OBJECT_NUM_MAX];
        enemy   = new Enemy[Const.OBJECT_NUM_MAX];
        explosion = new Explosion[Const.OBJECT_NUM_MAX];
        for (int i = 0; i < Const.OBJECT_NUM_MAX; i ++ ){
            bullet[i]       = new Bullet(atlas.cut(362, 66, 3, 8));
            enemy[i]        = new Enemy(atlas.cut(8, 108, 18, 18));
            explosion[i]    = new Explosion(atlas.cut(200, 220, 122, 34));
        }
    }

    public synchronized void start(){

        if(running) return;

        running         = true;
        engineThread    = new Thread(this);
        engineThread.start();
    }

    public synchronized void stop(){

        if(!running) return;

        running = false;
        try{
            engineThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clearUp();
    }

    private void bulletAdd(){
        if(bulletCount > 15) {
           bulletCount = 0;
            for (int i = 0; i < 10; i++) {
                if (!bullet[i].activ) {
                    bullet[i].add(x + 12, y - 2);
                    //System.out.println(i);
                    break;
                }
            }
        }
    }

    private void enemyAdd(){
        if(enemyCount > 30){
            enemyCount = 0;
            for(int i = 0; i < 30; i ++) {
                if (!enemy[i].activ) {
                    enemy[i].add(random.nextInt(Const.FRAME_WIDTH - 20), 0, 1);
                    break;
                }
            }
        }
    }

    private void hit(){
        for(int i = 0; i < 30; i ++) {
            if(enemy[i].activ) {
                float xe1 = enemy[i].getX();
                float xe3 = xe1 + enemy[i].getWidth();
                float ye1 = enemy[i].getY();
                float ye3 = ye1 + enemy[i].getHeight();
                for(int j = 0; j < 10; j ++){
                    if(bullet[j].activ){
                        float xb4 = bullet[j].getX();
                        float xb3 = xb4 + bullet[j].getWidth() * 0.5f;
                        float xb2 = xb4 + bullet[j].getWidth();
                        float yb1 = bullet[j].getY();
                        float yb3 = yb1 + bullet[j].getHeight();
                        float yb4 = yb1 + bullet[j].getHeight() * 0.2f;
                        if(     xb4 >= xe1 && xb4 <= xe3 && yb4 >= ye1 && yb4 <= ye3 ||
                                yb3 >= ye1 && yb3 <= ye3 && xb3 >= xe1 && xb3 <= xe3 ||
                                xb2 >= xe1 && xb2 <= xe3 && yb4 >= ye1 && yb4 <= ye3 ||
                                yb1 >= ye1 && yb1 <= ye3 && xb3 >= xe1 && xb3 <= xe3 ) {
                            bullet[j].destroy();
                            enemy[i].pushDamage(bullet[j].getDamage());
                            if (enemy[i].getHealth() <= 0) {
                                for (int l = 0; l < Const.OBJECT_NUM_MAX; l++) {
                                    if (!explosion[l].activ) {
                                        explosion[l].add((int) (enemy[i].getX() + enemy[i].getWidth() / 2),
                                                (int) (enemy[i].getY() + enemy[i].getHeight() / 2));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void update(){

        if(input.getKey(KeyEvent.VK_UP)){
            y -= step;
            if(y < 0) y = 0;
        }
        if(input.getKey(KeyEvent.VK_DOWN)){
            y += step;
            if(y > Const.FRAME_HEIGHT - 35) y = Const.FRAME_HEIGHT - 35;
        }
        if(input.getKey(KeyEvent.VK_LEFT)){
            x -= step;
            if(x < 0) x = 0;
        }
        if(input.getKey(KeyEvent.VK_RIGHT)){
            x += step;
            if(x > Const.FRAME_WIDTH - 35) x = Const.FRAME_WIDTH - 35;
        }
        if(input.getKey(KeyEvent.VK_SPACE)){
            bulletAdd();
        }
        for(int i = 0; i < 30; i ++) {
            if (bullet[i].activ)    bullet[i].update();
            if (enemy[i].activ)     enemy[i].update();
            explosion[i].update();
        }
        bulletCount ++;
        enemyCount ++;
        enemyAdd();
        hit();
    }

    private void render(){

        display.clear();
        for(int i = 0; i < 30; i ++) {
            bullet[i].render(graphics);
            enemy[i].render(graphics);
            explosion[i].render(graphics);
        }
        sprite.render(graphics, x, y);
        display.swapBuffers();
    }

    public void run(){

        int fps     = 0;
        int upd     = 0;
        int updl    = 0;

        long count  = 0;

        float delta = 0;
        long lastTime = Time.get();
        while(running){
            long now = Time.get();
            long elapsedTime = now - lastTime;

            count += elapsedTime;

            lastTime = now;
            boolean render = false;
            delta += elapsedTime / Const.UPDATE_INTERVAL;
            while(delta > 1.0){
                update();
                upd ++;
                if(render){
                    updl ++;
                }else{
                    render = true;
                }
                delta --;
            }

            if(render){
                render();
                fps ++;
            }else{
                try{
                    Thread.sleep(Const.IDLE_TIME);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            if(count >= Const.SECOND){

                display.setTitle(Const.FRAME_TITLE + " || Fps: " + fps + " | Upd: " + upd + " | Updl: " + updl);

                count   = 0;
                fps     = 0;
                upd     = 0;
                updl    = 0;
            }
        }
    }

    private void clearUp(){
        display.destroy();
    }
}
