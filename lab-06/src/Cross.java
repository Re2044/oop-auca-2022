public class Cross extends Shape{
    private Rectangle first;
    private Rectangle second;
    Cross(Rectangle first, Rectangle second){
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean contains(int x, int y) {
        if(first.contains(x,y) && second.contains(x,y)){
            return true;
        }
        else
            return false;
    }
    @Override
    public void moveShape(int x,int y){
        this.first.moveShape(x,y);
        this.second.moveShape(x,y);
    }
    @Override
    public String toString(){
        return "Cross: ("+first.toString()+"), ("+second.toString()+")";
    }
}
