import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problem02 extends JFrame {
    Problem02(){
        setTitle("First GUI App");
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        Color BackgroundColor = Color.RED;

        JPanel mJPanel = new JPanel ();
        JPanel cJpanel = new JPanel();
        mJPanel.setBackground(Color.RED);
        cJpanel.setBackground(Color.DARK_GRAY);


        add(mJPanel,BorderLayout.CENTER);
        add(cJpanel,BorderLayout.SOUTH);
        var RedJButton = new JButton("RED");
        var GreenJButton = new JButton("GREEN");
        var BlueJButton = new JButton("BLUE");

        cJpanel.add(RedJButton);
        cJpanel.add(GreenJButton);
        cJpanel.add(BlueJButton);
        RedJButton.addActionListener(e -> {mJPanel.setBackground(Color.RED);});
        GreenJButton.addActionListener(e -> {mJPanel.setBackground(Color.GREEN);});
        BlueJButton.addActionListener(e -> {mJPanel.setBackground(Color.BLUE);});



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        Problem02 window = new Problem02();
    }
}
