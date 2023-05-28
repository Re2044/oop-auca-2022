import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.sql.Time;
import java.util.EventListener;

import static java.awt.font.GraphicAttribute.ROMAN_BASELINE;

public class Main extends JFrame implements ActionListener {

    private final Field myField;
    private final Snake mySnake;

    @Override
    public void actionPerformed(ActionEvent e) {
        mySnake.move();
    }

    class Canvas extends JPanel{
        Canvas(){
            var timer = new Timer(DELAY,e->{mySnake.move();repaint();});
           // timer.setRepeats(false);
            timer.start();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            float canvasWidth = this.getWidth()/(float)myField.getCol();
            float canvasHeight = this.getHeight()/(float)myField.getRow();
            float canvasSize = Math.min(canvasHeight,canvasWidth);
            float fieldWidth = canvasSize * myField.getCol();
            float fieldHeight = canvasSize * myField.getCol();
            float horShift = (this.getWidth() - fieldWidth)*0.5f;
            float verShift = (this.getHeight() - fieldHeight)*0.5f;
            for(int i = 0;i<myField.getRow();i++){
                for(int j = 0;j<myField.getCol();j++){
                    float posX = horShift + i*canvasSize;
                    float posY = verShift + j*canvasSize;
                    g2D.setColor(myField.getColor());
                    g2D.fill(new Rectangle2D.Float(posX,posY,canvasSize-GAP_PX,canvasSize-GAP_PX) );
                }
            }

            mySnake.draw((Graphics2D) g,this.getWidth(),this.getHeight());
            myField.getApple().draw((Graphics2D)g,getWidth(),getHeight());




           // MyApple.draw(g,this.getWidth(),this.getHeight());
        }
    }

    Main(){
        setTitle("Wise snake devouring golden apples in the magic world");
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout layoutManager = new CardLayout();
        setLayout(layoutManager);
        var mJPanel = new Canvas();

        myField = new Field(numberOfColumns,numberOfRows, Color.DARK_GRAY);
        mySnake = new Snake(0,0,"right",myField,SNAKE_LENGTH);
        Apple apple = new Apple(0,Color.YELLOW,myField,mySnake);
        myField.setApple(apple);
       // MyApple = new Apple(0, Color.YELLOW,MyField);
        mJPanel.setFocusable(true);
        mJPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try{
                    mySnake.SetDirection(e.getKeyCode());
                }
                catch (IllegalStateException ex){
                    System.err.println(ex.getMessage());
                }
            }
        });
        mJPanel.setBackground(Color.BLACK);
        add(mJPanel);

       // this.pack();

    }


    public static void main(String[] args) {
         new Main().setVisible(true);
    }


}