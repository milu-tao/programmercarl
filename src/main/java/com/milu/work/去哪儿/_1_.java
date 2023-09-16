package com.milu.work.去哪儿;

import java.util.*;

public class _1_ {

    public static void main(String[] args) {

//        int[] q = findQ(10, new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE, 20, 20, 99, 20, 99, 100, 100});


//        int[] q = findQ1(8, new int[]{10,20,20,99,20,99,100,100});

//        int[] q = findQ1(0, new int[]{});
//        Random random = new Random();
//        int[] ints = new int[50];
//        for(int i =0; i< 50; i++){
//            ints[i] = random.nextInt(500);
//        }
        int[] ints = new int[]{500,500};
        int[] q = findQ1(ints.length, ints);

        for (int i : q){
            System.out.print(i + " ");

        }

    }


    public static int[] findQ (int n, int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i : nums){
            list.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            if(!set.contains(list.get(i))){
                set.add(list.get(i));
            }else{
                list.remove(i);
                i--;
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for(Integer i : list){
            result[index++] = i;
        }
        return result;
    }

    public static int[] findQ1 (int n, int[] nums) {
        Set<Integer> set = new HashSet<>();

        int[] result = new int[nums.length];
        int index = 0;

        for(int i : nums){
            if(!set.contains(i)){
                result[index++] = i;
                set.add(i);
            }
        }
        int[] ints = Arrays.copyOfRange(result, 0, index);
        return ints;
    }
}
