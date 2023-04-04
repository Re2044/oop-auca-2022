import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
public class Problem01 extends JFrame{
    Problem01(){
        setTitle("First Swing App");
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mJPanel = new JPanel ();
        JPanel cJpanel = new JPanel();
        mJPanel.setBackground(Color.RED);
        cJpanel.setBackground(Color.GRAY);


        add(mJPanel,BorderLayout.CENTER);
        add(cJpanel,BorderLayout.SOUTH);
        cJpanel.add(new JButton("RED"));
        cJpanel.add(new JButton("GREEN"));
        cJpanel.add(new JButton("BLUE"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        Problem01 window = new Problem01();

    }
}
