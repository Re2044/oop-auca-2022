import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
public class Problem03 extends JFrame{
    Problem03(){
        setTitle("First Swing App");
        setSize(400,400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mJPanel = new JPanel ();
        mJPanel.setBackground(Color.DARK_GRAY);
        mJPanel.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {}
                @Override
                public void mouseMoved(MouseEvent e) {
                    String title = e.getX()+", "+e.getY();
                    setTitle(title);
                }
            }
        );
        this.add(mJPanel);
    }
    public static void main(String args[]){
        Problem03 window = new Problem03();

    }
}
