import java.awt.*;
import java.util.Random;

public class Apple {
    private int row;
    private int col;
    private Random generator;
    private Color color;
    private Field field;
    public Apple(int seed, Color color,Field field){
        generator = new Random(seed);
        changeLocation(0,field.getRow(),0,field.getCol());
        this.color = color;
        this.field = field;
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
        g.fillOval((width/field.getCol())*col,(height/field.getRow())*row,width/field.getCol(),height/field.getRow());
    }
}
