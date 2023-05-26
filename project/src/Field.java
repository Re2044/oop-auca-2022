import javax.swing.*;
import java.awt.*;

public class Field {
    private final Color color;
    private final int rowCount;
    private final int columnCount;
    public Field(int rowCount,int columnCount,Color color){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.color = color;
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

}
