
import java.util.Scanner;

public class URI2062 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        String input = in.nextLine();
        String[]ins = input.split(" ");
        for(int i = 0;i<ins.length;i++){
            if(ins[i].length()==3){
                if(ins[i].substring(0,2).equals("UR")){
                    ins[i] = "URI";
                }
                if(ins[i].substring(0,2).equals("OB")){
                    ins[i] ="OBI";
                }
            }
        }
        for(int i = 0;i<ins.length;i++) {
            if(i!=ins.length-1)
                System.out.print(ins[i]+" ");
            else
                System.out.println(ins[i]);
        }
    }
}
