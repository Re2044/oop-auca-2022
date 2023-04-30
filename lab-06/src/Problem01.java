import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;
public class Problem01 {
    static public class Rectangle{
        private int xpos = 0;
        private int ypos = 0;
        private int xend=0;
        private int yend = 0;
        Rectangle(int xpos,int ypos,int xend,int yend){
            this.xpos=xpos;
            this.ypos = ypos;
            this.xend = xend;
            this.yend = yend;
        }
        public boolean contains(int x,int y){
            if(x>=xpos && x<=xend && y>=ypos && y<=yend){
                return true;
            }
            else
                return false;
        }
        public int getX(){
            return xpos;
        }
    }
    public static void Main(String args[]){
        Scanner in = new Scanner(System.in);
        Rectangle first = new Rectangle(10,10,100,100);
        Rectangle second = new Rectangle(10,10,100,100);
        while(true){
            System.out.print("x:");
            int x = in.nextInt();
            System.out.println("y:");
            int y = in.nextInt();
            if(first.contains(x,y)){
                System.out.println("Rectangle:");
            }
        }
    }
}
