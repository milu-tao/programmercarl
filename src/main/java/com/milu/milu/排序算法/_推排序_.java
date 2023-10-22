package com.milu.milu.排序算法;

import java.util.List;

public class _推排序_ {
    public static void main(String[] args) {
//        sort(new int[]{ 1 ,8,2,1});
        sort(new int[]{8, 1, 2, 5, 3, 5, 4, 8, 2, 5, 4, 8, 1, 2, 4, 8, 2, 5, 8, 2, 1, 3, 8, 9, 7, 6});
    }

    /**
     * 步骤
     * 1. 原地建最大堆，得到最大的数字，然后放到数组的最后，所以需要一个数字记录当前堆多大
     */
    private static int heapSize;

    private static void sort(int[] array){
        heapSize = array.length;
        //原地建堆
        for(int i = (array.length>>1)-1; i >=0 ;i -- ){
            siftDown(i,array);
        }

        while (heapSize > 1){
            //交换第一个和堆的最后一个元素
            swap(0, --heapSize,array);

            //恢复堆的性质
            siftDown(0,array) ;

        }

        for(int a : array){
            System.out.print(a + " ");
        }
    }

    private static void siftDown(int index,int[] array) {
        Integer element = array[index];

        //这里是heapSize，因为排序的是，在排序的过程中，heap会在逻辑上是变小的
        int half = heapSize >> 1;
        //index必须是非叶子节点，不然没有下滤的必要
        while(index < half){
            //默认是左边节点
            int childIndex = (index << 1 ) + 1 ;
            Integer child = array[childIndex];
            int rightIndex = childIndex + 1;
            //对比，拿到左右节点，比较大的哪一个
            if(rightIndex < heapSize && array[rightIndex] > child){
                child = array[rightIndex];
                childIndex = rightIndex;
            }

            if(element >= child) {
                break;
            }
            array[index] = child;
            index = childIndex;

        }
        array[index] = element;
    }

    private static void swap(int i, int j,int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
