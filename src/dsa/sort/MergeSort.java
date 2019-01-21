package dsa.sort;

/**
 * 归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，
 * 因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。
 * 归并排序算法分析
 * 1.将待排序序列均分为2个待排序序列（循环直到序列不可再分）
 * 2.分别对2个序列进行排序
 * 3.合并两个已排序序列
 * Recursive algorithm.
 * Runs in O(NlogN) time.
 * Basic idea: If we have two sorted arrays, we can merge them in linear time
 * with N comparisons only. Given an array to be sorted, we can consider separately
 * its left half and its right half, sort them and then merge them.
 * @author dongfei
 */
public class MergeSort {
    public static void sort(Integer[] a) {
        mergeSort(a,0,a.length-1,new Integer[a.length]);
    }

    /**
     * 定义一个临时数组是为了避免在递归中频繁开辟空间，按照最初的归并排序逻辑，应该是递归合并时创建
     * @param a
     * @param left
     * @param right
     * @param tmp
     */
    private static void mergeSort(Integer[] a,int left,int right,Integer[] tmp){
        if(right > left) {
            int middle = left + (right - left) / 2;
            mergeSort(a,left,middle,tmp);
            mergeSort(a,middle+1,right,tmp);
            merge(a, left, middle, right,tmp);
        }
    }

    public static void merge(Integer[] a,int left,int middle,int right,Integer[] tmp){
        //左边序列下标
        int leftIndex = left;
        //右边序列下标
        int rightIndex = middle+1;
        //临时序列下标
        int t = 0;
        //左右子集比较
        while (leftIndex<=middle && rightIndex<=right){
            if(a[leftIndex]<=a[rightIndex]){
                tmp[t++] = a[leftIndex++];
            }else {
                tmp[t++] = a[rightIndex++];
            }
        }
        //先将左边自己添加（其实先添加左边还是右边无所谓，因为走到这的先决条件是左子集和右子集至少一个已经循环完毕）
        //如果是左边的先处理完，说明右子集剩下的都比左边大；同样的道理如果右边的先处理完了，说明左边的比右边的大
        while(leftIndex<=middle){
            tmp[t++] = a[leftIndex++];
        }
        //再将右边子集添加
        while(rightIndex<=right){
            tmp[t++] = a[rightIndex++];
        }
        t = 0;
        while(left <= right){
            a[left++] = tmp[t++];
        }
    }
}
