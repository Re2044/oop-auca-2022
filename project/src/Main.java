import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.font.GraphicAttribute.ROMAN_BASELINE;

public class Main extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public void addCompToPane(Container p){

        cards = new JPanel(new CardLayout());

        var mJPanel = new Field();
        mJPanel.setFocusable(true);
        var StartButton = new JButton("Start the Game");
        StartButton.setFont();
        mJPanel.setBackground(Color.BLACK);

        var cJPanel = new JPanel();
        cJPanel.setBackground(Color.DARK_GRAY);


        cards.add(mJPanel, "card 1");
        cards.add(cJPanel, "card 2");

        p.add(cards,BorderLayout.CENTER);
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