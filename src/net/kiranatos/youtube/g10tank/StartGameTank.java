package net.kiranatos.youtube.g10tank;

import java.io.IOException;
import net.kiranatos.youtube.g10tank.game.Game;

/*
YouTube channel: TheByteGuru https://www.youtube.com/channel/UCQ_FVsybLSxo-lN9GGjsaDA
Playlist: Пишем игру на Java(Ява) - Клон Танков https://www.youtube.com/playlist?list=PLwVvOVLAoKQl84bk2aCtkZgfb0qvq6ZHA

path to atlas in Game class
path to level1 in Level class
*/

public class StartGameTank {   
    public static void main(String[] args) throws IOException {
        Game tanks = new Game();
        tanks.start();
    }
}
    
    /*
Перечитать все комменты в последних двух видео №10 №11
https://www.youtube.com/playlist?list=PLwVvOVLAoKQl84bk2aCtkZgfb0qvq6ZHA
*/
    
    
    /*
    public static void main(String[] args) {
        
        Display.create(800, 600, "Tanks", 0xff00ff00, 3); //гексадецимальное значение
        
        Timer t = new Timer (1000/60, new AbstractAction(){ //60 рaz в сек интревал времени за которую вызывает некоторую функцию
            @Override
            public void actionPerformed(ActionEvent e) {                
                Display.clear();
                Display.render();
                Display.swapBuffers();
            }
        });
        
        t.setRepeats(true); //таймер должен повторятся иначе он пробежит только раз
        t.start();
        
    } */


/*
Найти таблицы
цвета в гексадецимальном формате
*/