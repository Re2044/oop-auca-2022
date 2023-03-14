import java.util.Scanner;
import java.util.regex.Pattern;

public class URI2253 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String pass = in.nextLine();
            if(pass.length()<6 || pass.length()>32){
                System.out.println("Senha invalida.");
            }
            else{
                boolean flag = true;
                boolean dig = false;
                boolean up = false;
                boolean down = false;
                if (Pattern.matches("\\p{Punct}",pass )){
                    flag=false;
                }
                for(int i =0 ;i<pass.length();i++){
                    if(pass.charAt(i) ==' '){
                        flag=false;
                        break;
                    }
                    if(Character.isDigit(pass.charAt(i))){
                        dig = true;
                    }
                    if(Character.isLowerCase(pass.charAt(i))){
                        down = true;
                    }
                    if(Character.isUpperCase(pass.charAt(i))){
                        up = true;
                    }
                }
                if(flag==true && up==true && dig==true && down==true){
                    System.out.println("Senha valida.");
                }
                else{
                    System.out.println("Senha invalida.");
                }
            }
        }
    }
}
