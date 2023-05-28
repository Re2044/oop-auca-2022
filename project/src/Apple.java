import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import static game.utilities.DrawingHelpers.*;
import static game.Params.*;
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
        g.fill(new Rectangle2D.Float(horShift+canvasSize*col,verShift+canvasSize*row,canvasSize-GAP_PX,canvasSize-GAP_PX));
    }
}
