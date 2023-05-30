import game.Params;
import game.controllers.FieldController;
import game.controllers.SnakeController;
import game.models.*;
import game.views.AppleView;
import game.views.FieldView;
import game.views.SnakeView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static game.Params.*;

public class Main extends JFrame {
    private static Field myField;
    private static Snake mySnake;
    CardLayout layoutManager = new CardLayout();
    JPanel containerPanel = new JPanel();
    private static boolean gameState = false;
    private static int currScore;
    private static int bestScore;
    private static int gameSpeed = 200;
    class Canvas extends JPanel{
        Canvas(){
            var timer = new Timer(gameSpeed,e->{

                if(gameState){
                    if(mySnake.isDead()){
                        layoutManager.last(containerPanel);
                        gameState = false;
                        bestScore = Math.max(bestScore,currScore);
                    }
                    else{
                        mySnake.move();
                        currScore = mySnake.getScore();
                        repaint();
                    }
                }
            });
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

        var startButton = new JButton("New Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currScore = 0;
                bestScore = 0;
                layoutManager.next(containerPanel);
                myField = new Field(numberOfRows,numberOfColumns,FIELD_DEFAULT_COLOR);
                mySnake = new Snake(SNAKE_BEGIN_POS_X,SNAKE_BEGIN_POS_Y,SNAKE_DEFAULT_DIRECTION,myField,SNAKE_LENGTH);
                myField.setApple(new Apple(0,APPLE_DEFAULT_COLOR,myField));
                gameState = true;
            }
        });
        var menuButton = new JButton("Main menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutManager.first(containerPanel);
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
                        mySnake.setDirection("up");
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
                        mySnake.setDirection("down");
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
                        mySnake.setDirection("right");
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
                        mySnake.setDirection("left");
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        });



        var currScorePanel = new JLabel("Score: "+currScore);
        currScorePanel.setForeground(Color.WHITE);
        currScorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mJPanel.add(currScorePanel,BorderLayout.NORTH);

        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(new GridBagLayout());

        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);

        startButton.setFont(BASIC_FONT);
        startButton.setAlignmentX(CENTER_ALIGNMENT);
        startButton.setBackground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setForeground(Color.WHITE);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);

        var Title = new JLabel("Wise snake devouring golden apples in the magic world");
        Title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,45));
        Title.setForeground(Color.RED);


        var gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        menuPanel.add(Title,gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        var exitButton = new JButton("Exit");
        exitButton.addActionListener(e->{System.exit(0);});
        exitButton.setFont(BASIC_FONT);
        exitButton.setAlignmentX(CENTER_ALIGNMENT);
        exitButton.setBackground(Color.BLACK);
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);

        buttonPanel.add(startButton,gbc);
        buttonPanel.add(exitButton,gbc);
        menuPanel.add(buttonPanel,gbc);

        restartPanel.setBackground(Color.BLACK);
        restartPanel.setLayout(new GridBagLayout());
        menuButton.setFont(BASIC_FONT);

        var endButtonPanel = new JPanel();
        endButtonPanel.setLayout(new GridBagLayout());
        endButtonPanel.setBackground(Color.BLACK);
        endButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        var lostLabel = new JLabel("You Lost");
        lostLabel.setFont(new Font(Font.DIALOG,Font.BOLD,45));
        lostLabel.setForeground(Color.RED);
        lostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        var scoreLabel = new JLabel("Your Score is : " + currScore);
        scoreLabel.setForeground(Color.GREEN);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBackground(Color.BLACK);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFocusPainted(false);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        var secExitButton =  new JButton("Exit");
        secExitButton.addActionListener(e->{System.exit(0);});
        secExitButton.setFont(BASIC_FONT);
        secExitButton.setAlignmentX(CENTER_ALIGNMENT);
        secExitButton.setBackground(Color.BLACK);
        secExitButton.setFocusPainted(false);
        secExitButton.setForeground(Color.WHITE);
        secExitButton.setBorderPainted(false);
        secExitButton.setContentAreaFilled(false);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.CENTER;
        restartPanel.add(lostLabel,gbc);
        restartPanel.add(scoreLabel,gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        restartPanel.add(menuButton,gbc);
        restartPanel.add(secExitButton,gbc);

        containerPanel.add(menuPanel,BorderLayout.CENTER);
        containerPanel.add(mJPanel);
        containerPanel.add(restartPanel);


       add(containerPanel);




    }


    public static void main(String[] args) {
         new Main().setVisible(true);
    }
}