import java.util.ArrayList;
import java.util.Scanner;

public class Problem03 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10,10,100,100));
        shapes.add(new Rectangle(400,400,100,100));
        shapes.add(new Circle(500,10,100));
        shapes.add(new Circle(800,800,100));
        while (true) {
            System.out.print("x:");
            int x = in.nextInt();
            System.out.print("y:");
            int y = in.nextInt();
            if (x == -1)
                break;
            for(var it :shapes){
                if(it.contains(x,y)){
                    System.out.println(it);
                }
            }
        }
    }
}
