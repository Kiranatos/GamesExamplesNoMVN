package net.kiranatos.youtube.g15snake;

public class Apple {
    
    SnakeGame main;    
    public int posX;
    public int posY;
    
    public Apple(int startX, int startY){
        posX = startX;
        posY = startY;
    }
    
    @SuppressWarnings("static-access")
    public void setRandomPosition(){
        posX = (int) (Math.random()* main.WIDTH);
    }    
}
