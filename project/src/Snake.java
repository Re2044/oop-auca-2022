import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Snake {
    private Field field;
    private int dx,dy;
    private ArrayList<Point> body = new ArrayList<>();
    private String direction;
    private Color colorAlive;
    private Color colorDead;
    private Point head;
    private boolean IsDead;
    private int score;
    Snake(int x,int y,int dx,int dy,Field field){
        this.dx =dx;
        this.dy = dy;
        head = new Point(x,y);
        body.add(head);
        this.colorAlive = Color.RED;
        this.colorDead = Color.GRAY;
        IsDead=false;
        score = 0;
        this.field = field;
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
            g.fillRect((width/field.getCol())*col,(height/field.getRow())*row,width/field.getCol(),height/field.getRow());
        }
    }
    public ArrayList<Point> getBody(){
        return body;
    }
    public Point getHead(){
        return head;
    }
    public int getScore(){
        return score;
    }
    public void move(){
        if(IsDead)
            return;
        if(body.size()==10){
            body.remove(0);
        }
        if(field.isCords(head.x+dx,head.y+dy))
            body.add(new Point(head.x+dx,head.y+dy));
        else{
            IsDead = true;
        }
    }
    public void SetDirection(String newDirection){
        if(!direction.equals("right") && !direction.equals("left") && !direction.equals("up") && !direction.equals("down")){
            throw new IllegalArgumentException("Wrong direction name");
        }
        else{
            switch(newDirection){
                case "left":
                    if(direction.equals("right")) throw new IllegalStateException("Cannot change direction this way");
                    else direction = newDirection;
                    dx = -1;
                    dy = 0;
                    break;
                case "right":
                    if(direction.equals("left")) throw new IllegalStateException("Cannot change direction this way");
                    else direction = newDirection;
                    dx = 1;
                    dy = 0;
                    break;
                case "up":
                    if(direction.equals("down")) throw new IllegalStateException("Cannot change direction this way");
                    else direction = newDirection;
                    dx = 0;
                    dy = -1;
                    break;
                case "down":
                    if(direction.equals("up")) throw new IllegalStateException("Cannot change direction this way");
                    else direction = newDirection;
                    dx = 0;
                    dy = 1;
                    break;
            }
        }
    }
    public void SetDirection(int KeyCode){
        switch(KeyCode){
            case VK_LEFT:
                SetDirection("left");
                break;
            case VK_RIGHT:
                SetDirection("right");
                break;
            case VK_UP:
                SetDirection("up");
                break;
            case VK_DOWN:
                SetDirection("down");
                break;
        }

    }
}
