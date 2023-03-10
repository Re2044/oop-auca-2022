import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("First rational: ");
            String FirstRational = in.nextLine();
            Rational first = new Rational(1, 1);
            try {first = Rational.parseRational(FirstRational);}
            catch (IllegalArgumentException ex) {
                System.err.println("Error: "+ex);
                continue;
            }
            System.out.print("Operator: ");
            String Symbol = in.nextLine();
            try{Rational.CheckSymbol(Symbol);}
            catch (IllegalArgumentException ex){
                System.err.println("Error: "+ex);
                continue;
            }
            System.out.print("Second rational: ");
            String SecondRational = in.nextLine();
            Rational second = new Rational(1, 1);
            try {second = Rational.parseRational(SecondRational);}
            catch (IllegalArgumentException ex) {
                System.err.println("Error: "+ex);
                continue;
            }
            var Result = Rational.Operation(first,second,Symbol);
            System.out.println(Rational.toString(first)+" "+Symbol+" "+Rational.toString(second)+" : "+Result);
        }
    }
}

