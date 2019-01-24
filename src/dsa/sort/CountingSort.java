package dsa.sort;

/**
 *
 计数排序
 分类	排序算法
 数据结构	数组
 最坏时间复杂度	{\displaystyle O(n+k)} O(n+k)
 最优时间复杂度	{\displaystyle O(n+k)} O(n+k)
 平均时间复杂度	{\displaystyle O(n+k)} O(n+k)
 最坏空间复杂度	{\displaystyle O(n+k)} O(n+k)
 计数排序（Counting sort）是一种稳定的线性时间排序算法。
 当输入的元素是 {\displaystyle n} n个 {\displaystyle 0} {\displaystyle  0 }到 {\displaystyle k}  k 之间的整数时，
 它的运行时间是 {\displaystyle \Theta (n+k)} {\displaystyle \Theta (n+k)}。计数排序不是比较排序，排序的速度快于任何比较排序算法。
 计数排序使用一个额外的数组 {\displaystyle C}  C ，其中第i个元素是待排序数组 {\displaystyle A} A中值等于 {\displaystyle i} i的元素的个数。
 然后根据数组 {\displaystyle C}  C 来将 {\displaystyle A} A中的元素排到正确的位置。
 * @author dongfei
 */
public class CountingSort {

    public static void sort(Integer[] a){
        int[] sorted = new int[a.length];
        int[] minAndMax = findMaxAndMin(a);
        int min = minAndMax[0];
        int max = minAndMax[1];
        if(min == max) {
            return ;
        }
        int[] counting = new int[max-min+1];
        //计数：统计待排序数组中每个元素出现的次数，放入计数数组该元素值对应下标位置，下标即该元素值（确切的说是元素值与最小值的差值）
        for(int i=0;i<a.length;i++){
            counting[a[i]-min] +=1;
        }
        //将统计数组中的元素分别与前一个元素求和，并赋值给当前元素
        //为什么要累加呢？因为之前已经将下标（待排序元素值）与出现次数统计完成，累加计算相当于统计出该元素应该存放的位置（同一元素出现多次的时候递减）
        for(int i=1;i<counting.length;i++){
            counting[i] = counting[i-1] + counting[i];
        }
        //反向填充，将待排序数组中的元素，逆向添加到新数组（排序数组），同时待排序数组每取出一个元素，计数数组对应的位置减一（存放到减一位置）
        //--在前先计算后取值（因为计数没考虑下标从0开始的问题，比如14个数统计最大和为14，但是在数组里是0-13）
        for(int i= a.length-1; i>=0;i--){
            sorted[--counting[a[i]-min]] = a[i];
        }
        for(int i=0;i<a.length;i++){
            a[i] = sorted[i];
        }
    }

    public static int[] findMaxAndMin(Integer[] a){
        if(a == null || a.length <1) {
            return new int[]{0,0};
        }
        int min = a[0];
        int max = a[0];
        for(int i = 1; i < a.length;i++) {
            if(max < a[i]){
               max = a[i];
            }
            if(min>a[i]) {
                min = a[i];
            }
        }
        return new int[]{min,max};
    }
}
