package net.kiranatos.youtube.g12platf;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class Panel extends JPanel implements Runnable {
    public static enum STATES {PLAY, MENUE , SETTINGS};
    public static STATES state = STATES.MENUE;
    public static ArrayList<Image> boxi;

    JTextField filed = new JTextField();

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    public static boolean chik = true; // цикл While

    public static boolean board = false; // цикл While

    public static Audio a_play;

    private int FPS;//
    private double millisToFPS;// fps в миллсек
    private int timer = FPS;// таймер fps
    private int sleepTime; //сколько он будет спать
    private static Thread thread; // Создаем поток-ссылкy на обьект класса Thread

    private BufferedImage image;
    private Graphics2D g;

    GameBack gameBack = new GameBack();
    Player player = new Player();
    Let let = new Let();
    Listeners listeners = new Listeners();
    GameBoard gameBoard = new GameBoard();
    Menue menue = new Menue();
    Patreon patreon = new Patreon();
    Settings settings = new Settings();

    public Panel() {
        super();
        setFocusable(true);
        requestFocus();
        addKeyListener(new Listeners());
        addMouseListener(new Listeners());// добавляем обработчик событий клик мышь
        addMouseMotionListener(new Listeners());
    }

    public void myStart() {
        thread = new Thread((Runnable) this);
        thread.start();// запускаем поток
    }

    @Override
    public void run() {
        FPS = 30; // задаем желаемый FPS
        millisToFPS = 1000 / FPS; //пересчет в миллисек
        sleepTime = 0;

        boxi = new ArrayList<Image>();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boxi.add(let.boxImage1);
        boxi.add(let.boxImage3);
        boxi.add(let.boxImage4);

      if(chik == true) {
          a_play = new Audio(Paths.SOUND_PLAY, 0);

          a_play.play();// играть
          a_play.setVolume();// громкость воспроизведения
          a_play.repeat();// повторять
          a_play.sound();//взрыв врага
      }

        while (true) { // игровой цикл
            if(state.equals(STATES.SETTINGS)){
                menue.menueUpdate();
                menue.menueDraw(g);
                menue.crossSettings.drawBut(g);
                menue.CrossSettings(menue.crossSettings);
                settings.onAudio.drawBut(g);
                settings.offAudio.drawBut(g);
                settings.offAudioSettingsUpdate(settings.offAudio);
                settings.onAudioSettingsUpdate(settings.onAudio);
                gameDraw();
            }

            if(state.equals(STATES.MENUE)){
                menue.menueUpdate();
                menue.menueDraw(g);
                menue.play.drawBut(g);
                menue.settings.drawBut(g);
                menue.settingsUpdate(menue.settings);
                menue.update(menue.play);
                patreon.patreon.drawBut(g);
                patreon.patreonUpdate(patreon.patreon);
                let.VersionDraw(g);
                gameDraw();
            }

            if (state.equals(STATES.PLAY)) {
                gameBack.GameDraw(g);
                gameBack.update();
                if (player.Fly1 == true || player.Fly2 == true) {
                    player.FlyDraw(g);
                    player.updateFly();
                } else {
                    player.AnimDraw(g);
                    player.update();
                }
                draw();
                update();
                gameDraw();
            }
            double timerFPS = System.nanoTime();// присвоим текущ время
        timerFPS = (System.nanoTime() - timerFPS) / 1000000;//сколько прошло миллсек на операции выше
        if (millisToFPS > timerFPS) {
            sleepTime = (int) (millisToFPS - timerFPS);
        } else sleepTime = 1;

        try {
            thread.sleep(sleepTime); //засыпаем на ... мс
        } catch (InterruptedException ex) { //если не удается заснуть- исключение
            ex.printStackTrace();
        }
        timerFPS = 0;// обнуляем таймер
        sleepTime = 1;// обновляем время сна
        }
    }
    
    public void update() {
        Iterator<Image> i = boxi.iterator();

        while(i.hasNext()){
             Image e = i.next();
            if(player.getRect().intersects(let.getRect1())){
                gameBack.GameOver = true;
            }
            if(player.getRect().intersects(let.getRect2())){
                gameBack.GameOver = true;
            }
            if(player.getRect().intersects(let.getRect3())){
                gameBack.GameOver = true;
            }
        }
            let.BoxUpdate();
            if(gameBack.GameOver == true){
                gameBoard.overUpdate();
            }
    }

    public void draw(){
        player.YDraw(g);
        let.Y1Draw(g);
        let.drawBox(g);

        if(gameBack.GameOver == true){

            gameBoard.boardDraw(g);
            gameBoard.boradsDraw(g);
            gameBoard.scoreDraw(g);
            gameBoard.recordDraw(g);
            menue.cross.drawBut(g);
            menue.CrossBoard(menue.cross);
        }
    }

    public void gameDraw(){
        Graphics g2 = this.getGraphics();// переоппред Graphics2d на Graphics
        g2.drawImage(image, 0, 0, null);// рисуем
        g2.dispose();// команда для уборщщика мусора
    }
}