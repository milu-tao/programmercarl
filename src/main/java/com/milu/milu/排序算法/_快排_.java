package com.milu.milu.排序算法;


import static com.milu.milu.排序算法._堆排序_.swap;

public class _快排_ {

    public static void main(String[] args) {
        int[] sort = sort(new int[]{8, 1, 2, 5, 3, 5, 4, 8, 2, 5, 4, 8, 1, 2, 4, 8, 2, 5, 8, 2, 1, 3, 8, 9, 7, 6});
        for(int s : sort){
            System.out.print(s+ " ");
        }
    }

    private static int[] sort(int[] arrays) {
        quickSort(0,arrays.length,arrays);
        return arrays;
    }

    private static void quickSort(int begin, int end, int[] arrays) {
        if (end - begin < 2) {
            return;
        }

        int mid = pivotIndex(begin,end,arrays);
        quickSort(begin,mid,arrays);
        quickSort(mid + 1 ,end,arrays);

    }
    // 构造[begin,end)
    private static int pivotIndex(int begin, int end,int[] arrays) {
        //随机选择一个元素，可以在一定程度上减低排序
        swap(begin, begin + (int)(Math.random() * (end - begin)),arrays );

        //同样降低交换次数，所以提前记录
        int pivot = arrays[begin];

        //[begin,end)
        end --;

        while (begin < end){
            //右边开始
            while (begin < end){
                if(pivot < arrays[end] ){
                    end--;
                }else{
                    arrays[begin ++ ] = arrays[end];
                    break;
                }
            }
            //左边
            while (begin < end){
                if(pivot > arrays[begin]){
                    begin++;
                }else{
                    arrays[end--] = arrays[begin];
                    break;
                }
            }
        }
        arrays[begin] = pivot;

        return begin;


    }

}
