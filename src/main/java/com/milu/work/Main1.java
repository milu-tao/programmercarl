package com.milu.work;

public class Main1 {
    /**
     * 写一个工具，冒泡排序
     */
    public static void main(String[] args) {
        int[] ints = {9,8,7,6,5,4,1,};

        mao(ints);
        mao(null);

        for(int i : ints){
            System.out.println(i);
        }
    }

    public static void mao(int[] nums){
        if(nums == null){
            return;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] < nums[j]){
                    //swap
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
