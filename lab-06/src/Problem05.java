import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Problem05 extends JFrame {
    ArrayList<Shape> shapes = new ArrayList<>();
    Problem05(){
        setTitle("Graph Editor");
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mJPanel = new JPanel ();
        JPanel cJpanel = new JPanel();
        mJPanel.setBackground(Color.WHITE);
        cJpanel.setBackground(Color.DARK_GRAY);


        add(mJPanel,BorderLayout.CENTER);
        add(cJpanel,BorderLayout.SOUTH);

        var RectJButton = new JButton("Rect");
        var CircleJButton = new JButton("Circle");
        var CrossJButton = new JButton("Cross");

        cJpanel.add(RectJButton);
        cJpanel.add(CircleJButton);
        cJpanel.add(CrossJButton);
        Random rand = new Random();
        RectJButton.addActionListener(e -> {shapes.add(new Rectangle(rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100)));});
        CircleJButton.addActionListener(e -> {shapes.add(new Circle(rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100)));});
        CrossJButton.addActionListener(e -> {shapes.add(new Cross(new Rectangle(rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100)),new Rectangle(rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100),rand.nextInt(0,100))));});
        System.out.println(shapes.size());
    }
    public static void main(String args[]){
        Problem05 curr  = new Problem05();
    }
}
