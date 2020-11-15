package net.kiranatos;

import java.io.IOException;
import net.kiranatos.github.g22tictactoe.StartGameTicTacToe;

import net.kiranatos.javarush.g01arcanoid.Arcanoid;
import net.kiranatos.javarush.g02galaxian.Space;
import net.kiranatos.javarush.g04snake.Room;
import net.kiranatos.javarush.g03tetris.Tetris;

import net.kiranatos.youtube.g10tank.StartGameTank;
import net.kiranatos.youtube.g11galaxian.StartGalaxian;
import net.kiranatos.youtube.g12platf.Start2DPlatformer;
import net.kiranatos.youtube.g14snake.SnakeMainWindow;
import net.kiranatos.youtube.g15snake.SnakeGame;
import net.kiranatos.youtube.g16xonix.GameXonix;
import net.kiranatos.youtube.g17tetris.GameTetris;
import net.kiranatos.youtube.g18sapper.GameMines;
import net.kiranatos.youtube.g19snake.GameSnake;
import net.kiranatos.youtube.g20galaxian.GameSpaceInvaders;


public class Start_Games {     
    private static String theChoice;
    
    public static void main(String[] args) throws IOException, Exception {
        OzoHelper.printMe(null, 
                "#######################################################################################",
                "#######################################################################################",
                "##### Проект-справочник games, не использующий Maven или подключаемых библиотек ####",
                "#######################################################################################",
                "\n Choose games:",
                "1. JavaRush 2014 : Arcanoid",
                "2. JavaRush 2014 : Galaxian",
                "3. JavaRush 2014 : Tetris",
                "4. JavaRush 2014 : Snake",
                "5. ",
                "6. ",
                "7. ",                
                "8. ",
                "9. ",
                "10. Tank from \t\t|| Youtube channel << TheByteGuru: Пишем игру на Java(Ява) - Клон Танков>>",
                "11. Galaxian (on Tank game engine(10), from some comment in youtube, source was lost years ago)",
                "12. 2D Платформер \t|| Youtube channel << NeIT >>",
                "13. Puzzle \t\t|| Youtube channel <<Ирина Галкина: Игра Puzzle. Часть 1-4>>",
                "14. Snake \t\t|| Youtube channel <<Ирина Галкина: создание игры Змейка. Часть 1-3>>",
                "15. Snake \t\t|| Youtube channel <<NomadRussian: Пишем змейку на Java>>",
                "16. Xonix \t\t|| Youtube channel <<Сергей Ирюпин: Пишем игру Xonix>>",
                "17. Tetris \t\t|| Youtube channel <<Сергей Ирюпин: Пишем классический Тетрис>>",
                "18. Сапёр! \t\t|| Youtube channel <<Сергей Ирюпин: Пишем игру Сапёр>>",
                "19. Classic Snake \t|| Youtube channel <<Сергей Ирюпин: Пишем классическую игру Snake>>",
                "20. Space Invaders \t|| Youtube channel <<Сергей Ирюпин: Пишем игру Space Invaders>>",
                "21. Морской бой \t|| Youtube channel <<Сергей Ирюпин: Игра Морской бой на Java>>",
                "22. Tic Tac Toe 3D \t|| GitHub Repository <<Сергей Ирюпин: github.com/biblelamp>>",
                "23. ",
                "exit",
                "______________________________________________________________");
        
        theChoice = OzoHelper.getRead();
        System.out.println("Your choice: " + theChoice);
        
        switch (theChoice) {
            case "1":
                Arcanoid.main(null);
                break;      
            case "2":          
                Space.main(null);
                break;
            case "3":
                Tetris.main(null);
                break;
            case "4":
                Room.main(null);
                break;
                
                
                
            case "8":             
                System.out.println("Error");
                break;
            case "9": 
                System.out.println("Error");
                break;
                
                
                
            case "10": 
                System.out.println("\nБЛОГГЕР БРОСИЛ КАНАЛ. ИГРА НЕ ЗАКОНЧЕНА\n");
                StartGameTank.main(null);
                break;                
            case "11": 
                StartGalaxian.main(null);
                break;
            case "12": 
                Start2DPlatformer.main(null);
                break;
            case "13": 
                System.out.println("\nБЛОГГЕР БРОСИЛ КАНАЛ. ИГРА НЕ ЗАКОНЧЕНА\n");
                break;
            case "14": 
                SnakeMainWindow.main(null);
                break;
            case "15": 
                SnakeGame.main(null);
                break;
            case "16": 
                GameXonix.main(null);
                break;
            case "17": 
                GameTetris.main(null);
                break;
            case "18": 
                GameMines.main(null);
                break;
            case "19": 
                GameSnake.main(null);
                break;
            case "20": 
                GameSpaceInvaders.main(null);
                break;
            case "21": 
                net.kiranatos.youtube.g21battleship.GameBattleShip.main(null);
                break;
            case "22": 
                StartGameTicTacToe.main(null);
                break;
            case "23": 
                System.out.println("");
                break;
            case "exit": 
                System.exit(0);
                break;
            default: 
                System.out.println("Incorrect choice !!!");
                Start_Games.main(null);
                break;
        } // end switch
    } // end main method
    
}
