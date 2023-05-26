import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private int length;
    private ArrayList<Integer> arrayRow = new ArrayList<>();
    private ArrayList<Integer> arrayCol = new ArrayList<>();
    private int rowCount;
    private int columnCount;
    private String direction;
    private static Color color = Color.RED;
    Snake(int rowCount,int columnCount,String direction){
        this.direction = direction;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        arrayRow.add(0);
        arrayCol.add(0);
        length = 1;
    }
    public void Paint(Graphics g, int width, int height){
        g.setColor(color);
        for(int i = 0; i<arrayRow.size();i++)   {
            int col = arrayCol.get(i);
            int row = arrayRow.get(i);
            g.fillOval((width/columnCount)*col,(height/rowCount)*row,width/columnCount,height/rowCount);
        }
    }
    public void move(int nextRow,int nextCol){
        if(length==10){
            arrayCol.remove(0);
            arrayRow.remove(0);
        }
        arrayCol.add(nextCol);
        arrayRow.add(nextRow);
    }
}
