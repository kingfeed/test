package dsa.sort;

/**
 * 希尔排序是建立的插入排序基础上的一种排序算法。
 * 希尔排序按其设计者希尔（Donald Shell）的名字命名，该算法由1959年公布。
 * 希尔排序通过将比较的全部元素分为几个区域（通过步长）来提升插入排序的性能。
 * https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F
 * 步长序列	最坏情况下复杂度
 * n/2^i     O(n^2)           n待排序序列长度，i循环次数
 * 2^k - 1   O(n^{3/2})       k循环次数
 * 2^i*3^j   O(n\log^2 n )
 * 已知的最好步长序列是由Sedgewick提出的(1, 5, 19, 41, 109,...)
 * @author dongfei
 *  * Improves on insertion sort.
 *  * Starts by comparing elements far apart, then elements less far apart,
 *  * and finally comparing adjacent elements (effectively an insertion sort).
 *  * By this stage the elements are sufficiently sorted that the running time
 *  * of the final stage is much closer to O(N) than O(N2).
 */
public class ShellSort {

    /**
     * 希尔设计时的步长算法n/2
     */
    public static void sort(Integer[] a) {
        if(a == null) {return;}
        int gap  = a.length/2;
        while (gap >= 1) {
            for(int i = gap; i<a.length;i++){
                int tmp = a[i];
                int j = i-gap;
                while (j>=0 && a[j] > tmp){
                    a[j+gap] = a[j];
                    j = j - gap;
                }
                a[j+gap] = tmp;
            }
            gap = gap/2;
        }
    }

    /**
     *优化后的步长设计算法
     */
    public static void sort2(Integer[] a) {
        if(a == null) {return;}
        int gap  = 1;
        while (gap<a.length/3){
            gap = gap * 3 + 1;
        }
       while (gap >= 1) {
            for(int i = gap;i<a.length;i++){
                int tmp = a[i];
                int j = i - gap;
                while(j >=0 && a[j]>tmp){
                    a[j+gap] = a[j];
                    j = j - gap;
                }
                a[j+gap] = tmp;
            }
            gap = gap/3;
        }
    }
}
