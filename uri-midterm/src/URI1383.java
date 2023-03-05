import java.util.Scanner;

public class URI1383 {
    public static void printmx(int[][]mx){
        for(int i = 0;i<mx.length;i++){
            for(int j = 0;j<mx.length;j++){
                System.out.print(mx[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean checkmr(int[][]mx,int sizeX,int sizeY){
        int[]check = new int[10];
        boolean flag =true;
        for(int i = 1 ;i<10;i++){
            check[i]=0;
        }
        for(int i = 0 ;i<sizeX;i++){
            for(int j =0;j<sizeY;j++){
                check[mx[i][j]]++;
                if(check[mx[i][j]]>1){
                    flag = false;
                }
            }
        }
        return flag;
    }
    public static boolean checkstr(int []str,int size){
        int[]check = new int[10];
        boolean flag =true;
        for(int i = 1 ;i<10;i++){
            check[i]=0;
        }
        for(int i = 0 ;i<size;i++) {
            check[str[i]]++;
            if (check[str[i]] > 1) {
                flag = false;
            }
        }
        return flag;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i = 0 ; i<k;i++){
            int [][] matrix = new int[9][9];
            int [][][] minimx = new int[9][3][3];
            for(int j = 0;j<9;j++){
                for(int h =0;h<9;h++){
                    int x =in.nextInt();
                    matrix[j][h]=x;
                    minimx[(j/3)*3+h/3][j%3][h%3]=x;
                }
            }
           // for(int j=0;j<9;j++){
             //   printmx(minimx[j]);
             //   System.out.println();
           // }
            System.out.println("Instancia "+(i+1));
            boolean flag =true;
            for(int j =0;j<9;j++) {
                if (checkmr(minimx[j], 3, 3) == false) {
                    flag = false;
                    //System.out.println("1 "+j);
                    break;
                }
            }
            for(int j=0;j<9;j++){
                if(checkstr(matrix[j],9)==false){
                    flag= false;
                   // System.out.println("2 "+j);
                    break;
                }
            }
            for(int j =0;j<9;j++){
                int[]check = new int[10];
                for(int ii = 1 ;ii<10;ii++){
                    check[ii]=0;
                }
                for(int h =0;h<9;h++){
                    check[matrix[h][j]]++;
                    if(check[matrix[h][j]]>1){
                        flag=false;
                   //     System.out.println("3 "+h);
                        break;
                    }
                }

            }
           if(flag==false)
                System.out.println("NAO");
           else{
               System.out.println("SIM");
           }

        }

    }
}
