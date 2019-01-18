package dsa.sort;

/**
 * 插入排序
 * 时间复杂度 n^2
 * 算法分析：
 * 1.假定当前元素之前的元素是有序序列
 * 2.当前元素与前序序列元素从后往前逐一对比，将大于当前元素值的元素后移，直到遇到小于等于当前元素值的元素，将当前元素插入其后
 * 3.循环以上步骤，直到最后一个元素，完成插入排序
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
