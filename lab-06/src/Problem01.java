import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;
public class Problem01 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Rectangle first = new Rectangle(10,10,100,100);
        Rectangle second = new Rectangle(400,400,100,100);
        while(true){
            System.out.print("x:");
            int x = in.nextInt();
            System.out.print("y:");
            int y = in.nextInt();
            if(x==-1)
                break;
            if(first.contains(x,y)){
                System.out.println(first);
            }
            if(second.contains(x,y)){
                System.out.println(second);
            }
        }
    }
}