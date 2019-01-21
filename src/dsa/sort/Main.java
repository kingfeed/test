package dsa.sort;

/**
 * @author dongfei
 */
public class Main {
    public static void main(String[] args){
        Integer[] a = new Integer[]{66,1,2,4,6,10,0,9,19,18,20,30,28,0};
        MergeSort.sort(a);
        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }
    }
}
