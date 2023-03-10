import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]) {
        Turtle[] TurtleArray = new Turtle[2];
        TurtleArray[0] = new Turtle("up", 0, 0, 0);
        TurtleArray[1]= new Turtle("up",2,19,19);
        Field field = new Field(20, 20, 2, TurtleArray, 0);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            boolean flag = false;
            String inString = in.nextLine();
            inString= inString.trim();
            String ins[] = inString.split(" ");
            for(int i = 0 ; i<ins.length;i++){
                ins[i]=ins[i].trim();
            }
            try {
                field.GetCommand(ins);
            }
            catch(IllegalArgumentException ex){
                System.err.println(ex);
            }
        }
        System.exit(0);

    }
}