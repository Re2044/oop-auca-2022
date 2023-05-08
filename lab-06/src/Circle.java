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
    public void moveShape(int x,int y){
        this.xpos = this.xpos +x;
        this.ypos = this.ypos +y;
    }
    public String toString(){return "Circle: "+xpos +", "+ ypos+", "+radius;}
}
