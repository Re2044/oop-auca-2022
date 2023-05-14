import java.awt.*;

public class Circle extends Shape {
    private int xpos = 0;
    private int ypos = 0;
    private int radius = 0;
    Circle(int xpos,int ypos,int radius){
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }
    @Override
    public boolean contains(int x,int y){
        if((x-xpos)*(x-xpos)+(y-ypos)*(y-ypos)<=radius*radius){
            return true;
        }
        else
            return false;
    }
    @Override
    public void moveShape(int x,int y,int width,int height){
        this.xpos = x-radius/2;
        this.ypos = y-radius/2;
        if(this.xpos+this.radius>width){
            this.xpos = width-this.radius;
        }
        if(this.ypos+this.radius>height){
            this.ypos = height-this.radius;
        }
        if(this.xpos<0){
            this.xpos = 0;
        }
        if(this.ypos<0){
            this.ypos = 0;
        }
    }
    @Override
    public String toString(){return "Circle: "+xpos +", "+ ypos+", "+radius;}
    @Override
    public void fill(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(xpos,ypos,radius,radius);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.drawOval(xpos,ypos,radius,radius);
    }
    @Override
    public int getX(){
        return xpos;
    }
    @Override
    public int getY(){
        return ypos;
    }
}
