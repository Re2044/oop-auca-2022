import javax.swing.*;
import java.awt.*;

public class Field {
    private Apple MyApple;

    private Snake MySnake;
    private int rowCount;
    private int columnCount;
    public Field(int rowCount,int columnCount){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        MySnake = new Snake(rowCount,columnCount,"Right");
        MyApple = new Apple(rowCount,columnCount,0);
    }
    public int getRow(){
        return rowCount;
    }
    public int getCol(){
        return columnCount;
    }
    public void draw(Graphics g,int width,int height){
        MyApple.draw(g,width,height);
        MySnake.draw(g,width,height);
    }

}
