import java.math.BigDecimal;
import java.util.Scanner;

public class URI1305 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String num = in.nextLine();
            String cutoff = in.nextLine();
            String num1="0";
            if(num.indexOf('.')!=-1 && num.indexOf('.')!=num.length()-1)
                num1 = num.substring(num.indexOf('.'),num.length());

            double cut = Double.parseDouble(num1);
            double ans = Double.parseDouble(num);
            double second = Double.parseDouble(cutoff);
            if(cut>second){
                System.out.println((int)(ans-cut+1));
            }
            else
                System.out.println((int)ans);
        }
    }
}
