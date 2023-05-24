import java.awt.*;
import java.sql.Array;

public abstract class Shape {
    public abstract boolean contains(int x, int y);

    public abstract void moveShape(int x,int y,int width,int height);

    public abstract void moveShape(int x,int y);

    public abstract void fill(Graphics g);

    public static Shape SelectedShape = null;

    public abstract void draw(Graphics g);

    public abstract int getX();
    public abstract int getY();

}
