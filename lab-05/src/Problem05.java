import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import javax.swing.JFrame;
public class Problem05 extends JFrame{
    private int column = 0;
    private int row = 0;
    Problem05(){
        setTitle("Move robot");
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var mJPanel = new CanvasPanel();
        mJPanel.setFocusable(true);
        this.add(mJPanel);
        mJPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_LEFT && column>0) column--;
                if(e.getKeyCode()==KeyEvent.VK_RIGHT && column<7) column++;
                if(e.getKeyCode()==KeyEvent.VK_UP && row>0) row--;
                if(e.getKeyCode()==KeyEvent.VK_DOWN && row<7) row++;
                repaint();
            }
        });
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
            g.setColor(Color.RED);
            g.fillOval(column*chessWidth,row*chessHeight,chessWidth,chessHeight);
        }

    }
    public static void main(String args[]){
        Problem05 window = new Problem05();

    }
}
