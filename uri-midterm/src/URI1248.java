import java.util.Scanner;

public class URI1248 {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();
        for(int i = 1;i<=n;i++){
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int [] cnt = new int[28];
            for(int j = 0;j<26;j++){
                cnt[i] = 0;
            }
            String a = in.nextLine();
            for(int j = 0;j<a.length();j++){
                cnt[a.charAt(j)-'A']++;
            }
            String b = in.nextLine();
            boolean flag = true;
            for(int j = 0;j<b.length();j++){
                cnt[b.charAt(j)-'A']--;
                if(cnt[b.charAt(j)-'A']<0){
                    flag= false;
                }
            }
            String c = in.nextLine();
            for(int j = 0;j<c.length();j++){
                cnt[c.charAt(j)-'A']--;
                if(cnt[c.charAt(j)-'A']<0){
                    flag= false;
                }
            }
            if(flag==false){
                System.out.println("CHEATER");
            }
            else{
                for(int j = 0;j<26;j++){
                    for(int k = 0;k<cnt[j];k++){
                        System.out.print(abc.charAt(j));
                    }
                }
                System.out.println();
            }
        }
    }
}
