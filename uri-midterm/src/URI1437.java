    import java.util.Scanner;

    public class URI1437 {
        public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            while(in.hasNext()){
                int len = in.nextInt();
                if(len==0){
                    break;
                }
                else{
                    String s1 = in.nextLine();
                    String s = in.nextLine();
                    int pos =  0;
                    for(int i = 0 ; i <s.length();i++){
                        if(s.charAt(i)=='E'){
                            if(pos==0){
                                pos = 3;
                            }
                            else{
                                pos-=1;
                            }
                        }
                        if(s.charAt(i)=='D'){
                            if(pos==3){
                                pos = 0;
                            }
                            else{
                                pos+=1;
                            }
                        }
                    }
                    switch (pos){
                        case 0:
                            System.out.println("N");
                            break;
                        case 1:
                            System.out.println("L");
                            break;
                        case 2:
                            System.out.println("S");
                            break;
                        case 3:
                            System.out.println("O");
                            break;
                    }
                }
            }
        }
    }
