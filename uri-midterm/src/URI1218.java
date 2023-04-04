import java.util.Scanner;

public class URI1218 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int i = 1;
        while(in.hasNextLine()){
            int search = Integer.parseInt(in.nextLine());
            String it = in.nextLine();

            String ins[] = it.split(" ");

            System.out.println("Caso "+i+":");
            int cntf = 0;
            int cntm = 0;
            for(int j = 0;j<ins.length;j+=2){

                if(Integer.parseInt(ins[j])==search){
                    if(ins[j+1].equals("F"))
                        cntf++;
                    else
                        cntm++;
                }
            }
            System.out.println("Pares Iguais: "+(cntf+cntm));
            System.out.println("F: "+cntf);
            System.out.println("M: "+cntm);
            System.out.println();
            i++;
        }
    }
}
