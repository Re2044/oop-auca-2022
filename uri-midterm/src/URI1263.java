import java.util.Scanner;
import java.util.regex.Pattern;

public class URI1263 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String input = in.nextLine();
            String[] ins = input.split(" ");
            int res =0;
            for(int i = 0;i<ins.length-1;i++){
                char first = Character.toLowerCase(ins[i].charAt(0));
                char second = Character.toLowerCase(ins[i+1].charAt(0));
                if(i!=0){
                    char third = Character.toLowerCase(ins[i-1].charAt(0));
                    if(first==second && third!=first){
                        res++;
                    }
                }

                else{
                    if(first==second){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
