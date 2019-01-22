package dsa.sort;

/**
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F
 * 在平均状况下，排序 {\displaystyle n} n个项目要 {\displaystyle \ O(n\log n)} {\displaystyle \ O(n\log n)}（大O符号）次比较
 * 在最坏状况下则需要 {\displaystyle O(n^{2})} {\displaystyle O(n^{2})}次比较，但这种状况并不常见。
 * 事实上，快速排序 {\displaystyle \Theta (n\log n)} {\displaystyle \Theta (n\log n)}通常明显比其他算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地达成。
 * @author dongfei
 */
public class QuickSort {

    public static void sort(Integer[] a){
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(Integer[] a,int head,int tail) {
        if (head >= tail || a == null || a.length <= 1) {
            return;
        }
        int pivot = a[(head+tail)/2];
        int from = head;
        int to = tail;
        while (from <= to ) {
            while (a[from] < pivot){
                from++;
            }
            while(a[to] > pivot) {
                to--;
            }
            if(from < to) {
                int tmp = a[from];
                a[from] = a[to];
                a[to] = tmp;
                from++;
                to--;
            }else if(from == to) {
                from++;
            }
        }
        quickSort(a,head,to);
        quickSort(a,from,tail);
    }
}
