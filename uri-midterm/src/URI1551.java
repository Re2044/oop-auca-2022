import java.util.Scanner;

public class URI1551 {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        while(len>0){
            String x = in.nextLine();
            int[] alpha = new int[26];
            int cnt = 0;
            for(int i = 0 ; i<x.length();i++){
                if(Character.isLowerCase(x.charAt(i)) && alpha[x.charAt(i)-'a']==0) {
                    alpha[x.charAt(i) - 'a']++;
                    cnt++;
                }
            }
             if(cnt==26){
                 System.out.println("frase completa");
            }
            else if(cnt>=13){
                 System.out.println("frase quase completa");
            }
            else {
                 System.out.println("frase mal elaborada");
            }
            len--;
        }
    }
}
