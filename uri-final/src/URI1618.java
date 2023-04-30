import java.util.Scanner;

public class URI1618 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i<n;i++){
            int ax,ay,bx,by,cx,cy,dx,dy,rx,ry;
            ax = in.nextInt();
            ay = in.nextInt();
            bx = in.nextInt();
            by = in.nextInt();
            cx = in.nextInt();
            cy = in.nextInt();
            dx = in.nextInt();
            dy = in.nextInt();
            rx = in.nextInt();
            ry = in.nextInt();
            if(rx >= ax && rx <= bx && rx >= dx && rx <= cx && ry >= ay && ry <= dy && ry >= by && ry <= cy){
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}
