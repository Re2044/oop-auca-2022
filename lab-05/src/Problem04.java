import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
public class Problem04 extends JFrame{
    Problem04(){
        setTitle("First Swing App");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var mJPanel = new CanvasPanel();

        this.add(mJPanel);
    }
    class CanvasPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            int chessWidth = this.getWidth()/8;
            int chessHeight = this.getHeight()/8;
            for(int i = 0;i<8;i++){
                for(int j = 0;j<8;j++){
                    if((i+j)%2==0)
                        g.setColor(Color.BLACK);
                    else
                        g.setColor(Color.WHITE);
                    g.fillRect(chessWidth*i,chessHeight*j,chessWidth,chessHeight);
                }
            }
        }
    }
    public static void main(String args[]){
        Problem04 window = new Problem04();

    }
}
