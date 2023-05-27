import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Snake {
    private int length;
    private ArrayList<Point> body = new ArrayList<>();
    private int rowCount;
    private int columnCount;
    private String direction;
    private Color colorAlive;
    private Color colorDead;
    private Point head;
    private boolean IsDead;
    Snake(int rowCount,int columnCount,String direction){
        this.direction = direction;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        head = new Point(0,0);
        body.add(head);
        length = 1;
        this.colorAlive = Color.RED;
        this.colorDead = Color.DARK_GRAY;
        IsDead=false;
    }
    public void draw(Graphics g, int width, int height){
        if(IsDead)
            g.setColor(colorDead);
        else
            g.setColor(colorAlive);
        for(int i = 0; i<body.size();i++)   {
            var point = body.get(i);
            int row = point.x;
            int col = point.y;
            g.fillOval((width/columnCount)*col,(height/rowCount)*row,width/columnCount,height/rowCount);
        }
    }
    public void move(){
        if(length==10){
            body.remove(0);
        }
        switch(direction){
            case "left":
                body.add(new Point(head.x-1, head.y));
                if(head.x==0){

                }
                break;
            case "up":
                body.add(new Point(head.x, head.y-1));
                break;
            case "down":
                body.add(new Point(head.x, head.y+1));
                break;
            case "right":
                body.add(new Point(head.x+1, head.y));
                break;
        }
    }
    public void SetDirection(String newDirection){
        direction = newDirection;
    }
    public void SetDirection(int KeyCode){
        switch(KeyCode){
            case VK_LEFT:
                if(direction.equals("right")){
                    throw new IllegalStateException("Cannot change direction this way");
                }
                else{
                    SetDirection("left");
                }
            case VK_RIGHT:
                if(direction.equals("left")){
                    throw new IllegalStateException("Cannot change direction this way");
                }
                else {
                    SetDirection("right");
                }
            case VK_UP:
                if(direction.equals("down")){
                    throw new IllegalStateException("Cannot change direction this way");
                }
                else{
                    SetDirection("up");
                }
            case VK_DOWN:
                if(direction.equals("up")){
                    throw new IllegalStateException("Cannot change direction this way");
                }
                else{
                    SetDirection("down");
                }
        }

    }
}
