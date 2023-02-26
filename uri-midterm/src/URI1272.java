import java.util.Scanner;

public class URI1272 {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        for(int i = 0 ; i <len ; i++){
            String input = in.nextLine();
            String[]ins = input.split("·");
            String res = "";
            for(int j  = 0;j<ins.length;j++){
                if(ins[j].isEmpty()==false){
                    res+=ins[j].charAt(0);
                }
            }
            System.out.println(res);
        }
    }
}
