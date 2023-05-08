public class Rectangle extends Shape{
    private int xpos = 0;
    private int ypos = 0;
    private int width =0;
    private int height = 0;
    Rectangle(int xpos,int ypos,int width,int height){
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean contains(int x,int y){
        if(x>=xpos && x<=xpos+width && y>=ypos && y<=ypos+height)return true;
        else return false;
    }

    @Override
    public void moveShape(int x,int y){
        this.xpos = this.xpos +x;
        this.ypos = this.ypos +y;
    }
    @Override
    public String toString(){return "Rect: "+xpos +", "+ ypos+", "+width+", "+height;}

}
