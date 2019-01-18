package dsa.sort;

/**
 * 插入排序
 * 时间复杂度 n^2
 * @author dongfei
 */
public class InsertionSort {

    public static void main(String[] args) {
        sort();
    }

    public static void sort(){
        Integer[] a = new Integer[]{66,1,2,4,6,10,0,9,19,18,20,30,28,0};
        for(int k = 1; k < a.length;k++){
            int previousIndex = k-1;
            int currentElement = a[k];
            while(previousIndex >=0 && currentElement < a[previousIndex] ) {
                a[previousIndex + 1] = a[previousIndex--];
            }
            a[previousIndex+1] = currentElement;
        }
        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }
    }

}
