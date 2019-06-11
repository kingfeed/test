package dsa.sort;

/**
 * 冒泡排序
 * 算法分析：
 * 1.每遍历一次，比较相邻两个元素，将元素值大的元素后移，直到遍历结束（此时最大元素在末尾）
 * 2.循环遍历，遍历元素为元素个数减去趟数【遍历次数】（已排序元素）
 * 百度百科
 * 比较相邻的元素。 如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。 在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 * 冒泡排序，大值下沉
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
