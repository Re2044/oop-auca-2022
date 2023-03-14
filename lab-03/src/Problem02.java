import java.math.BigInteger;
import java.util.Scanner;

public class Problem02 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("First rational: ");
            String FirstBigRational = in.nextLine();
            BigInteger BigOne = new BigInteger("1");
            BigRational first = new BigRational(BigOne, BigOne);
            try {first = BigRational.parseBigRational(FirstBigRational);}
            catch (IllegalArgumentException ex) {
                System.err.println("Error: "+ex.getMessage());
                System.out.println();
                continue;
            }
            System.out.print("Operator: ");
            String Symbol = in.nextLine();
            try{BigRational.CheckSymbol(Symbol);}
            catch (IllegalArgumentException ex){
                System.err.println("Error: "+ex.getMessage());
                System.out.println();
                continue;
            }
            System.out.print("Second rational: ");
            String SecondBigRational = in.nextLine();
            BigRational second = new BigRational(BigOne,BigOne);
            try {second = BigRational.parseBigRational(SecondBigRational);}
            catch (IllegalArgumentException ex) {
                System.err.println("Error: "+ex.getMessage());
                System.out.println();
                continue;
            }
            try{var Result = BigRational.Operation(first,second,Symbol);
                System.out.println("Result: "+BigRational.toString(first)+" "+Symbol+" "+BigRational.toString(second)+" : "+Result);}
            catch (NumberFormatException ex){
                System.err.println("Error: "+ex.getMessage());
                System.out.println();
                continue;
            }

        }
    }
}
