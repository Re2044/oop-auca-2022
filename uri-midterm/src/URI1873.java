import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URI1873 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        while(len>0){
            String it = in.nextLine();
            String []ins = it.split(" ");
            Map<String,Boolean>k = new HashMap<>();
            k.put("tesoura spock",false);
            k.put("spock tesoura",true);
            k.put("lagarto spock",true);
            k.put("spock lagarto",false);
            k.put("tesoura papel",true);
            k.put("papel tesoura",false);
            k.put("papel pedra",true);
            k.put("pedra papel",false);
            k.put("pedra lagarto",true);
            k.put("lagarto pedra",false);
            k.put("tesoura lagarto",true);
            k.put("lagarto tesoura",false);
            k.put("lagarto papel",true);
            k.put("papel lagarto",false);
            k.put("papel spock",true);
            k.put("spock papel",false);
            k.put("spock pedra",true);
            k.put("pedra spock",false);
            k.put("pedra tesoura",true);
            k.put("tesoura pedro",false);
            if(ins[0].equals(ins[1])){
                System.out.println("empate");
            }
            else{
                if(k.get(it)==true){
                    System.out.println("rajesh");
                }
                else
                    System.out.println("sheldon");
            }
            len--;
        }
    }
}
