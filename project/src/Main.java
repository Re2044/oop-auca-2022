import game.Params;
import game.controllers.SnakeActionController;
import game.models.*;
import game.views.AppleView;
import game.views.FieldView;
import game.views.SnakeView;


import static game.utilities.DrawingHelpers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import static game.Params.*;

public class Main extends JFrame {
    private static Field myField;
    private static Snake mySnake;
    CardLayout layoutManager = new CardLayout();
    JPanel containerPanel = new JPanel();
    private static boolean gameState = false;
    class Canvas extends JPanel{
        Canvas(){
            var timer = new Timer(DELAY,e->{if(gameState){if(mySnake.isDead()){ layoutManager.last(containerPanel);gameState = false;} else{mySnake.move();repaint();}}});
            timer.start();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            FieldView.draw(g2D,myField,this);
            SnakeView.draw(g2D,mySnake);
            AppleView.draw(g2D,myField.getApple());
        }
    }

    Main(){
        setTitle("Wise snake devouring golden apples in the magic world");
        setLocationRelativeTo(null);
        setSize(Params.WIDTH,Params.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        containerPanel.setLayout(layoutManager);

        var menuPanel = new JPanel();
        var restartPanel = new JPanel();

        var mJPanel = new Canvas();
        mJPanel.setBackground(Color.BLACK);

        var startButton = new JButton("Start the game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.next(containerPanel);
                mJPanel.setFocusable(true);
                myField = new Field(numberOfColumns,numberOfRows, FIELD_DEFAULT_COLOR);
                mySnake = new Snake(SNAKE_BEGIN_POS_X,SNAKE_BEGIN_POS_Y,SNAKE_DEFAULT_DIRECTION,myField,SNAKE_LENGTH);
                Apple apple = new Apple(0,APPLE_DEFAULT_COLOR,myField,mySnake);
                myField.setApple(apple);
                gameState = true;
            }
        });
        var restartButton = new JButton("Restart the game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.previous(containerPanel);
                mJPanel.setFocusable(true);
                myField = new Field(numberOfColumns,numberOfRows, FIELD_DEFAULT_COLOR);
                mySnake = new Snake(SNAKE_BEGIN_POS_X,SNAKE_BEGIN_POS_Y,SNAKE_DEFAULT_DIRECTION,myField,SNAKE_LENGTH);
                Apple apple = new Apple(0,APPLE_DEFAULT_COLOR,myField,mySnake);
                myField.setApple(apple);
                gameState = true;
            }
        });

        mJPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),"up");
        mJPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),"down");
        mJPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),"right");
        mJPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),"left");
        mJPanel.getActionMap().put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameState){
                    try{
                        mySnake.SetDirection("up");
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        });
        mJPanel.getActionMap().put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameState){
                    try{
                        mySnake.SetDirection("down");
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        });
        mJPanel.getActionMap().put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameState){
                    try{
                        mySnake.SetDirection("right");
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        });
        mJPanel.getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameState){
                    try{
                        mySnake.SetDirection("left");
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        });


        var adtPanel  = new JPanel();
        if(gameState){
            var currScore = new JLabel(String.valueOf(mySnake.getScore()));
            currScore.setLayout(new FlowLayout(FlowLayout.RIGHT));
            mJPanel.add(currScore,BorderLayout.NORTH);
        }

        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));
        startButton.setFont(BASIC_FONT);
        startButton.setBackground(Color.BLACK);
        startButton.setFocusPainted(false);
        menuPanel.add(startButton);
        restartPanel.setBackground(Color.BLACK);
        restartButton.setFont(BASIC_FONT);
        restartPanel.add(restartButton);


        containerPanel.add(menuPanel);
        containerPanel.add(mJPanel);
        containerPanel.add(restartPanel);


       add(containerPanel);




    }


    public static void main(String[] args) {
         new Main().setVisible(true);
    }
}