package dsa.sort;

/**
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F
 * 在平均状况下，排序 {\displaystyle n} n个项目要 {\displaystyle \ O(n\log n)} {\displaystyle \ O(n\log n)}（大O符号）次比较
 * 在最坏状况下则需要 {\displaystyle O(n^{2})} {\displaystyle O(n^{2})}次比较，但这种状况并不常见。
 * 事实上，快速排序 {\displaystyle \Theta (n\log n)} {\displaystyle \Theta (n\log n)}通常明显比其他算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地达成。
 * 算法步骤：
 *  1.从数列中挑出一个元素，称为“基准”（pivot），
 *  2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分割结束之后，该基准就处于数列的中间位置。这个称为分割（partition）操作。
 *  3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *  递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
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
