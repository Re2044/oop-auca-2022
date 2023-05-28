import game.models.*;
import game.view.AppleView;
import game.view.SnakeView;


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
            var timer = new Timer(DELAY,e->{mySnake.move();repaint();if(mySnake.isDead() && gameState){ layoutManager.last(containerPanel);gameState = false;}});

           // timer.setRepeats(false);
            timer.start();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            float canvasWidth = this.getWidth()/(float)myField.getCol();
            float canvasHeight = this.getHeight()/(float)myField.getRow();
            canvasSize = Math.min(canvasHeight,canvasWidth);
            float fieldWidth = canvasSize * myField.getCol();
            float fieldHeight = canvasSize * myField.getCol();
            horShift = (this.getWidth() - fieldWidth)*0.5f;
            verShift = (this.getHeight() - fieldHeight)*0.5f;
            for(int i = 0;i<myField.getRow();i++){
                for(int j = 0;j<myField.getCol();j++){
                    float posX = horShift + i*canvasSize;
                    float posY =verShift + j*canvasSize;
                    g2D.setColor(myField.getColor());
                    g2D.fill(new Rectangle2D.Float(posX,posY,canvasSize-GAP_PX,canvasSize-GAP_PX) );
                }
            }

            SnakeView.draw((Graphics2D) g,mySnake);
            AppleView.draw((Graphics2D) g,myField.getApple());




           // MyApple.draw(g,this.getWidth(),this.getHeight());
        }
    }

    Main(){
        gameState = true;
        setTitle("Wise snake devouring golden apples in the magic world");
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        containerPanel.setLayout(layoutManager);

        var menuPanel = new JPanel();
        var restartPanel = new JPanel();
        var  mJPanel = new Canvas();





        myField = new Field(numberOfColumns,numberOfRows, Color.DARK_GRAY);
        mySnake = new Snake(0,0,"right",myField,SNAKE_LENGTH);
        Apple apple = new Apple(0,Color.YELLOW,myField,mySnake);
        myField.setApple(apple);



        mJPanel.setBackground(Color.BLACK);

        var startButton = new JButton("Start the game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.next(containerPanel);
                mJPanel.setFocusable(true);
            }
        });
        var restartButton = new JButton("Restart the game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.previous(containerPanel);
                mJPanel.setFocusable(true);
                myField = new Field(numberOfColumns,numberOfRows, Color.DARK_GRAY);
                mySnake = new Snake(0,0,"right",myField,SNAKE_LENGTH);
                Apple apple = new Apple(0,Color.YELLOW,myField,mySnake);
                myField.setApple(apple);
                gameState = true;
            }
        });
        mJPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try{
                    if(gameState) { mJPanel.setFocusable(true); mySnake.SetDirection(e.getKeyCode());}
                }
                catch (IllegalStateException ex){
                    System.err.println(ex.getMessage());
                }
            }
        });
        var adtPanel  = new JPanel()
        var currScore = new JLabel(String.valueOf(mySnake.getScore()));
        currScore.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mJPanel.add(currScore,BorderLayout.NORTH);
        menuPanel.setBackground(Color.BLACK);
        startButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        menuPanel.add(startButton);
        restartPanel.setBackground(Color.BLACK);
        restartButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
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