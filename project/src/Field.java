import javax.swing.*;
import java.awt.*;

public class Field  extends JPanel {
    private int rowCount = 20;
    private int columnCount = 20;
    private int column = 0;
    private int row = 0;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int canvasWidth = this.getWidth()/rowCount;
        int canvasHeight = this.getHeight()/columnCount;
        for(int i = 0;i<rowCount;i++){
            for(int j = 0;j<columnCount;j++){
                g.drawRect(canvasWidth*i,canvasHeight*j,canvasWidth,canvasHeight);
            }
        }
        g.setColor(Color.RED);
        g.fillOval(column*canvasWidth,row*canvasHeight,canvasWidth,canvasHeight);
    }
}
