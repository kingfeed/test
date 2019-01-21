package dsa.sort;

/**
 * @author dongfei
 */
public class BubbleSort {

    public static void main(String[] args) {
        sort();
    }

    public static void sort(){
        Integer[] a = new Integer[]{66,1,2,4,6,10,0,9,19,18,20,30,28,0};
        for(int k=0;k<a.length-1;k++) {
            for (int i = 0; i < a.length-k-1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                }
            }
        }

        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }

    }

}
