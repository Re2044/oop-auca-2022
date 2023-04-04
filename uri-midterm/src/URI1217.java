import java.util.Scanner;
import java.util.Locale;
public class URI1217 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in).useLocale(Locale.US);;
        int n = in.nextInt();
        double sum = 0;
        int much  =0;

        for(int i = 1;i<=n;i++){
            double amount =in.nextDouble();
            String y = in.nextLine();
            String fruits = in.nextLine();
            int len = (fruits.split(" ")).length;
            much+=len;
            sum+=amount;
            System.out.println("day "+i+": "+len+" kg");
        }
        System.out.println(Math.round(((double) much/n)*100.0)/100.0+" kg by day");
        System.out.println("R$ "+Math.round(((double) sum/n)*100.0)/100.0+" by day");
    }
}
