import java.util.ArrayList;
import java.util.Scanner;

public class Problem04 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(10,10,100,100));
        shapes.add(new Rectangle(400,400,100,100));
        shapes.add(new Circle(500,10,100));
        shapes.add(new Circle(800,800,100));
        shapes.add(new Cross(new Rectangle(195, 575, 10, 50), new Rectangle(175, 595, 50, 10)));
        while(true){
            System.out.print("cmd: ");
            String cmd = in.next();
            switch (cmd){
                case "click":
                    System.out.print("x: ");
                    int x = in.nextInt();
                    System.out.print("y: ");
                    int y = in.nextInt();
                    for( var it : shapes){
                        if(it.contains(x,y)){
                            System.out.println(it);
                            break;
                        }
                    }
                    break;
                case "move":
                    System.out.print("x1: ");
                    int x1 = in.nextInt();
                    System.out.print("y1: ");
                    int y1 = in.nextInt();
                    System.out.print("x2: ");
                    int x2 = in.nextInt();
                    System.out.print("y2: ");
                    int y2 = in.nextInt();
                    for( var it : shapes){
                        if(it.contains(x1,y1)){
                            it.moveShape(x2-x1,y2-y1,1920,1080);
                            break;
                        }
                    }
                    break;
                case "present":
                    for( var it : shapes){
                        System.out.println(it);
                    }
                    break;
                case "stop":
                    System.exit(0);
            }

            //System.out.println("Rect: " + second.getX()+", "+second.getY()+", "+second.getXEnd()+", " +second.getYEnd());

        }
    }
}
