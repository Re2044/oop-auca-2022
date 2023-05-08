import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        mJPanel.setBackground(Color.RED);
        cJpanel.setBackground(Color.DARK_GRAY);


        add(mJPanel,BorderLayout.CENTER);
        add(cJpanel,BorderLayout.SOUTH);

        var RectJButton = new JButton("Rect");
        var CircleJButton = new JButton("Circle");
        var CrossJButton = new JButton("Cross");

        cJpanel.add(RectJButton);
        cJpanel.add(CircleJButton);
        cJpanel.add(CrossJButton);
        RectJButton.addActionListener(e -> {shapes.add(new Rectangle());
        CircleJButton.addActionListener(e -> {mJPanel.setBackground(Color.GREEN);});
        CrossJButton.addActionListener(e -> {mJPanel.setBackground(Color.BLUE);});
    }
    public static void main(String args[]){
        Problem05 curr  = new Problem05();
    }
}
