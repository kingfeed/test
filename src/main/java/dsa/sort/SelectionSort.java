package dsa.sort;

/**
 * 选择排序
 * 算法分析
 * 1.在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3.以此类推，直到所有元素均排序完毕。
 * @author dongfei
 */
public class SelectionSort {

    public static void sort(Integer[] a){
        int index = 0;
        int value = 0;
        for(int k = 0; k < a.length;k++){
            index = k;
            for(int i = k+1; i <a.length;i++){
                if(a[index] > a[i]){
                    index = i;
                }
            }
            value = a[index];
            a[index] =  a[k];
            a[k] = value;
        }
    }
}
