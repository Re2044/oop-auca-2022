import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String FirstRational = in.nextLine();
            String Symbol = in.nextLine();
            String SecondRational = in.nextLine();
            Rational first = new Rational(1, 1);
            try {
                first = Rational.parseRational(FirstRational);
            } catch (IllegalArgumentException ex) {
                System.err.println(ex);
            }
            Rational second = new Rational(1, 1);
            try {
                    second = Rational.parseRational(SecondRational);
                }
            catch (IllegalArgumentException sec) {
                    System.err.println(sec);
            }
            System.out.println(first.toString());
            System.out.println(second.toString());
            switch (Symbol) {
                    case "+":
                        first = first.Add(second);
                        break;
                    case "-":
                        first = first.subtract(second);
                        break;
                    case "/":
                        first = first.divide(second);
                        break;
                    case "*":
                        first = first.multiply(second);
                        break;
                    default:
                        throw new IllegalArgumentException("Incorrect operation");

            }
            System.out.println(first.toString());
        }
    }
}

