import java.util.Scanner;

public class URI1120 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int d = in.nextInt();
            String n = in.nextLine();
            if(d==0 && n.equals(" 0")){
                break;
            }
            String ans = "";

            for(int i = 0 ;i<n.length();i++){
                if(n.charAt(i)!=(char)(d+'0')){
                    ans+=n.charAt(i);
                }
            }
            int pos = 1;
            while(pos<ans.length() && ans.charAt(pos)=='0'){
                if(ans.charAt(pos)!='0')
                    break;
                pos++;

            }

            String res = "";
            for(int i = pos ;i <ans.length();i++){
                res+=ans.charAt(i);
            }
            if(res.length()==0){
                res = "0";
            }
            System.out.println(res);
        }
    }
}
