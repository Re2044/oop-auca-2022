import java.util.Scanner;

public class URI1241 {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        for(int i = 0 ; i <len ; i++){
            String input = in.nextLine();
            String[]ins = input.split(" ");
            String a= ins[0];
            String b = ins[1];

            if(a.length()<b.length()){
                System.out.println("nao encaixa");
            }
            else{
                String check = a.substring(a.length()-b.length(),a.length());
                if(check.equals(b)){
                    System.out.println("encaixa");
                }
                else{
                    System.out.println("nao encaixa");
                }
            }
        }
    }
}
