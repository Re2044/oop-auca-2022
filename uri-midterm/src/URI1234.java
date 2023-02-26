import java.util.Scanner;

public class URI1234 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String curr = in.nextLine();
            int cnt = 0;
            String res = "";
            for(int i = 0;i<curr.length();i++){
                if(curr.charAt(i)!=' '){
                    if(cnt%2==0){
                        res+=Character.toUpperCase(curr.charAt(i));
                    }
                    else
                        res+=curr.charAt(i);
                    cnt++;
                }
                else{
                    res+=curr.charAt(i);
                }
            }
            System.out.println(res);
        }
    }
}
