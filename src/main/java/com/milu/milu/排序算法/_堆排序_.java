package com.milu.milu.排序算法;

public class _堆排序_ {

    /**
     * 这个是堆排序 训练，重新写一遍
     */

    public static void main(String[] args) {
        int[] sort = sort(new int[]{8, 1, 2, 5, 3, 5, 4, 8, 2, 5, 4, 8, 1, 2, 4, 8, 2, 5, 8, 2, 1, 3, 8, 9, 7, 6});
        for(int s : sort){
            System.out.print(s+ " ");
        }
    }

    //记录当前数组中，前几个是堆了
    private static int heapSize;

    private static int[] sort(int[] ints) {
        heapSize = ints.length;
        //原地建堆 ,也就是将所有元素遍历一遍，下滤，当然排除掉叶子节点
        for(int i =  (ints.length >> 1) - 1; i >=0 ; i-- ){
            siftDown(i,ints);
        }

        while(heapSize > 1 ){
            swap(0 , --heapSize,ints);

            //恢复堆的性质
            siftDown(0,ints) ;
        }
        return ints;
    }

    //交换两个数组之间的位子
    static void swap(int i, int i1, int[] ints) {
        int tmp = ints[i];
        ints[i] = ints[i1];
        ints[i1] = tmp;
    }

    private static void siftDown(int index, int[] arrays) {
        //将元素进行下滤，因为这个堆的大小是由heapSize控制的
        //将元素提前保留，最后确定位置再交换位置
        int element = arrays[index];

        int half = heapSize >> 1;
        while (index < half){
            //默认都是左节点
            int childIndex = (index << 1) + 1;
            int child = arrays[childIndex];

            int rightIndex = childIndex + 1 ;
            if(rightIndex < heapSize && arrays[rightIndex] > child){
                child = arrays[rightIndex];
                childIndex = rightIndex;
            }

            if(child < element){
                break;
            }
            arrays[index] = child;
            index = childIndex;
        }
        arrays[index] = element;

    }
}
