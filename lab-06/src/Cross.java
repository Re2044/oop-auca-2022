import java.awt.*;
import java.util.Random;

public class Cross extends Shape{
    private Rectangle first;
    private Rectangle second;
    private  int width;
    private int height;
    private int xpos;
    private int ypos;
    Cross(int xpos, int ypos, int width, int height,Rectangle first,Rectangle second){
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
        this.first = first;
        this.second = second;
    }
    Cross(Rectangle first, Rectangle second){
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean contains(int x, int y) {
        if(x>=xpos && x<=xpos+width && y>=ypos && y<=ypos+height){
            return true;
        }
        else
            return false;
    }
    @Override
    public void moveShape(int x,int y,int width,int height){
        this.first.moveShape(x,y,width,height);
        this.second.moveShape(x,y,width,height);
        this.xpos = x - this.width/2;
        this.ypos = y - this.height/2;
        if(this.xpos+this.width>width){
            this.xpos = width-this.width;
        }
        if(this.ypos+this.height>height){
            this.ypos = height-this.height;
        }
        if(this.xpos<0){
            this.xpos = 0;
        }
        if(this.ypos<0){
            this.ypos = 0;
        }
    }
    @Override
    public void moveShape(int x,int y){
        this.xpos = this.xpos+x;
        this.ypos = this.ypos+y;
    }
    public int getX() {return xpos;}

    public int getY(){return ypos;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
    @Override
    public String toString(){
        return "Cross: ("+first.toString()+"), ("+second.toString()+")";
    }

    @Override
    public void fill(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(xpos,ypos,width,height);

    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(xpos,ypos,width,height);
    }
}
