import javax.swing.*;
import java.awt.*;

public class Field {
    private final Color color;
    private final int rowCount;
    private final int columnCount;
    private Apple apple;
    public Field(int rowCount,int columnCount,Color color){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.color = color;
        apple = new Apple(0,Color.YELLOW,this);
    }
    public int getRow(){
        return rowCount;
    }
    public int getCol(){
        return columnCount;
    }
    public Color getColor(){
        return color;
    }
    public Apple getApple(){return apple;}
    public boolean isCords(int x,int y) {
        if(x >= 0 && x < this.getCol() && y >= 0 && y < this.getRow()) return true;
        else return false;
    }
}

