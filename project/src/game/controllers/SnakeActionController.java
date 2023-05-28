package game.controllers;

import game.models.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SnakeActionController extends AbstractAction {
    private final String command;
    private Snake snake;
    private boolean gameState;
    public SnakeActionController(Snake snake,boolean gameState,String command){
        this.snake = snake;
        this.gameState = gameState;
        this.command = command;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setGameState(boolean gameState) {
        this.gameState = gameState;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (gameState) {
                snake.SetDirection(command);
            }
        }
        catch (IllegalStateException ex){
            System.err.println(ex.getMessage());
        }
    }
}
