package dsa.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://zh.wikipedia.org/wiki/%E6%A1%B6%E6%8E%92%E5%BA%8F
 * 桶排序以下列程序进行：
 * 设置一个定量的数组当作空桶子。
 * 寻访序列，并且把项目一个一个放到对应的桶子去。
 * 对每个不是空的桶子进行排序。
 * 从不是空的桶子里把项目再放回原来的序列中。
 * 当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间（ {\displaystyle \Theta (n)} {\displaystyle \Theta (n)}（大O符号））。
 * 但桶排序并不是比较排序，他不受到 {\displaystyle O(n\log n)} {\displaystyle O(n\log n)}下限的影响
 * 升级版的计数排序
 * @author dongfei
 */
public class BucketSort {
    public static final int defaultSize = 10;
    public static void sort(Integer[] a){
        int[] minAndMax = CountingSort.findMaxAndMin(a);
        int min = minAndMax[0];
        int max = minAndMax[1];
        if(min == max ){
            return;
        }
        int bucketSize = (max-min)/a.length + 1 > defaultSize?(max-min)/a.length + 1:defaultSize;
        int bucketCount = (max-min)/bucketSize +1;
        List<LinkedList<Integer>> buckets = new ArrayList<>(bucketCount);
        for(int i=0; i< bucketCount;i++){
            buckets.add(new LinkedList<Integer>());
        }
        for(int i=0;i<a.length;i++){
            buckets.get((a[i]-min)/bucketSize).add(a[i]);
        }
        Integer[] t;
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            t = new Integer[buckets.get(i).size()];
            buckets.get(i).toArray(t);
            InsertionSort.sort(t);
            for (int k : t) {
                a[index++] = k;
            }
        }
    }
}
