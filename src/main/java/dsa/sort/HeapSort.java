package dsa.sort;

/**堆排序（英语：Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆是一个近似完全二叉树的结构，
 * 并同时满足堆积的性质：即子节点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 通常堆是通过一维数组来实现的。在数组起始位置为0的情形中：
 * 父节点i的左子节点在位置 {\displaystyle (2i+1)} {\displaystyle (2i+1)};
 * 父节点i的右子节点在位置 {\displaystyle (2i+2)} {\displaystyle (2i+2)};
 * 子节点i的父节点在位置 {\displaystyle floor((i-1)/2)} {\displaystyle floor((i-1)/2)};
 *
 * 在堆的数据结构中，堆中的最大值总是位于根节点（在优先队列中使用堆的话堆中的最小值位于根节点）。堆中定义以下几种操作：
 * 最大堆调整（Max Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆（Build Max Heap）：将堆中的所有数据重新排序
 * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 * @author dongfei
 */
public class HeapSort {
    public  static void sort(Integer[] a){
        int startIndex = (a.length - 1)>>1;
        //堆化，堆化后，能确保
        for(int i=startIndex; i>=0;i--) {
            heapify(a, i,a.length - 1);
        }
        //排序
        for (int i = a.length - 1; i > 0; i--) {
            swap(a,0,i);
            heapify(a, 0, i - 1);
        }
    }

    public static void heapify(Integer[] a,int start, int end){
        if(end <=1){
            return;
        }
        int parentNode = start;
        int childNode = (parentNode<<1) + 1;
        while(childNode <= end) {
            if(childNode+1 < end && a[childNode] < a[childNode+1]){
                childNode++;
            }
            if(a[parentNode] > a[childNode]){
                return;
            }else {
                swap(a,parentNode,childNode);
                parentNode = childNode;
                childNode = (parentNode<<1) + 1;
            }
        }
    }

    public static void swap(Integer[] a,int i,int j){
        int tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
