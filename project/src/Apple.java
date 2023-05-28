import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Apple {
    private int row;
    private int col;
    private Random generator;
    private final Color color;
    private final Field field;
    private final Snake snake;
    public Apple(int seed, Color color,Field field, Snake snake){
        this.snake =snake;
        generator = new Random(seed);

        this.color = color;
        this.field = field;
        changeLocation();
    }
    public void changeLocation(){
        this.row = generator.nextInt(0,field.getCol());
        this.col = generator.nextInt(0,field.getRow());
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
    public void draw(Graphics2D g, int width,int height){
        g.setColor(color);
        g.fill(new Rectangle2D.Float((width/(float)field.getCol())*col,(height/(float)field.getRow())*row,width/(float)field.getCol(),height/(float)field.getRow()));
    }
}
