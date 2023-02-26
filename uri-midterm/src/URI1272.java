import java.util.Scanner;

public class URI1272 {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);
        int len = in.nextInt();
        String s = in.nextLine();
        for(int i = 0 ; i <len ; i++) {
            String input = in.nextLine();
            boolean flag = false;

            for (int pos = 0; pos < input.length(); pos++){
                if (input.charAt(pos) == ' ') {
                    flag = false;
                } else {
                    if (flag == false) {
                        System.out.print(input.charAt(pos));
                        flag = true;
                    }
                }
        }
            System.out.println();
    }


        }
    }

