import java.awt.*;
import java.util.Random;

public class Apple {
    private int row;
    private int col;
    private Random generator;
    private int rowCount;
    private int columnCount;
    private Color color;
    public Apple(int rowCount,int columnCount,int seed, Color color){
        generator = new Random(seed);
        this.rowCount =rowCount;
        this.columnCount = columnCount;
        changeLocation(0,rowCount,0,columnCount);
        this.color = color;
    }
    public void changeLocation(int minRow,int maxRow, int minCol,int maxCol){
        this.row = generator.nextInt(minRow,maxRow);
        this.col = generator.nextInt(minRow,maxRow);
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public Color getColor(){
        return this.color;
    }
    public void draw(Graphics g, int width,int height){
        g.fillOval((width/columnCount)*col,(height/rowCount)*row,width/columnCount,height/rowCount);
    }
}
