import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    int column = 0;
    int row = 0;
    int length = 8;
    int rowCount = 20;
    int columnCount = 20;
    Main(){

    }
    class SnakeField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            int chessWidth = this.getWidth()/rowCount;
            int chessHeight = this.getHeight()/columnCount;
            for(int i = 0;i<rowCount;i++){
                for(int j = 0;j<columnCount;j++){
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
    public static void main(String[] args) {
         new Main().setVisible(true);
    }
}