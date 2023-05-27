import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.font.GraphicAttribute.ROMAN_BASELINE;

public class Main extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static final int numberOfColumns = 20;
    public static final int numberOfRows = 20;

    private static Field MyField;
    private static Snake MySnake;
    private static Apple MyApple;
    class Canvas extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            int canvasWidth = this.getWidth()/MyField.getCol();
            int canvasHeight = this.getHeight()/MyField.getRow();
            for(int i = 0;i<MyField.getRow();i++){
                for(int j = 0;j<MyField.getCol();j++){
                    g.drawRect(canvasWidth*i,canvasHeight*j,canvasWidth,canvasHeight);
                }
            }
            MySnake.draw(g,this.getWidth(),this.getHeight());
            MyApple.draw(g,this.getWidth(),this.getHeight());
        }
    }
    public void addCompToPane(Container p){

        cards = new JPanel(new CardLayout());
        var mJPanel = new Canvas();
        MyField = new Field(numberOfColumns,numberOfRows, Color.BLACK);
        MySnake = new Snake(numberOfRows,numberOfColumns,"Right");
        MyApple = new Apple(numberOfRows,numberOfColumns,0, Color.YELLOW);
        mJPanel.setFocusable(true);
        mJPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                    try{
                        MySnake.SetDirection(e.getKeyCode());
                    }
                    catch (IllegalStateException ex){
                        System.err.println(ex.getMessage());
                    }
            }
        });
        //var StartButton = new JButton("Start the Game");
        //var buttonFont = new Font(Font.SANS_SERIF, Font.ITALIC, 30);
        //StartButton.setFont(buttonFont);
       // StartButton.addItemListener(new ItemListener() {
       //     @Override
       //     public void itemStateChanged(ItemEvent e) {
       //         CardLayout cl = (CardLayout)(cards.getLayout());
       //         cl.show(cards, (String)e.getItem());
       //     }
      //  });
        mJPanel.setBackground(Color.BLACK);

        var cJPanel = new JPanel();
        cJPanel.setBackground(Color.DARK_GRAY);
       // mJPanel.add(StartButton,BorderLayout.NORTH);

      //  cards.add(mJPanel, "card 1");
      //  cards.add(cJPanel, "card 2");

     //   p.add(cards,BorderLayout.CENTER);
    }
    JPanel cards;
    Main(){
        setTitle("Wise snake devouring golden apples in the magic world");
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addCompToPane(this.getContentPane());
        this.pack();

    }


    public static void main(String[] args) {
         new Main().setVisible(true);
    }


}