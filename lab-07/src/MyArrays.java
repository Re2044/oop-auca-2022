import java.awt.*;

interface MyComparable<Object> {
    int compareTo(Object a);

}
interface MyComparator<Object> {
    int compare(Object a,Object b);
}
public class MyArrays  {
    static public void sort(Object[] a, MyComparator comp){
        for(int i = 0 ;i<a.length;i++){
            int ind = i;
            for(int j = i+1;j<a.length;j++){
                if(comp.compare(a[j],a[ind])<0){
                    ind = j;
                }
            }
            var x = a[i];
            a[i] = a[ind];
            a[ind] = x;
        }
    }
    static public  void sort(BigRational[] a){
        for(int i = 0 ;i<a.length;i++){
            int ind = i;
            for(int j = i+1;j<a.length;j++){
                if(a[ind].compareTo(a[j])>0){
                    ind = j;
                }
            }
            var x = a[i];
            a[i] = a[ind];
            a[ind] = x;
        }
    }
    static public void sort(int [] a){
        for(int i = 0 ;i<a.length;i++){
            int ind = i;
            for(int j = i+1;j<a.length;j++){
                if(a[ind]>a[j]){
                    ind = j;
                }
            }
            var x = a[i];
            a[i] = a[ind];
            a[ind] = x;
        }
    }





}
