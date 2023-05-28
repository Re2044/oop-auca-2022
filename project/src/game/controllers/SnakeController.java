package game.controllers;

import game.models.Field;
import game.models.Snake;

import java.awt.*;

import static game.Params.*;

public class SnakeController {
    public static void setSnakeColorAlive(Color color, Snake snake){
        snake.setColorAlive(color);
    }
    public static void setSnakeColorDead(Color color, Snake snake){
        snake.setColorDead(color);
    }

}
