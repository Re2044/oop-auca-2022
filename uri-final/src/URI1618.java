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
            if(rx>Math.min(ax,Math.min(bx,Math.min(cx,dx))) && rx<Math.max(ax,Math.max(bx,Math.max(cx,dx)))){
                if(ry>Math.min(ay,Math.min(by,Math.min(cy,dy))) && ry<Math.max(ay,Math.max(by,Math.max(cy,dy)))){
                    System.out.println(1);
                }
                else
                    System.out.println(0);
            }
            else
                System.out.println(0);
        }
    }
}
