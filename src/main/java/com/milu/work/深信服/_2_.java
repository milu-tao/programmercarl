package com.milu.work.深信服;


import java.util.*;

public class _2_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int zu = in.nextInt();
        for(int i = 0; i < zu; i++){
            int hang = in.nextInt();
            Map<Integer,Integer> map = new TreeMap<>();
            int tmp = 0;
            for (int j = 0 ; j < hang;j++){
                tmp = in.nextInt();
                map.put(in.nextInt() , tmp);
                func(map);
            }
        }
    }

    private static void func(Map<Integer, Integer> map) {
        int[] nums = new int[map.size()];
        int index = map.get(1);
        for(int i = 0; i < map.size() ;i++){
            nums[i] = index;
            index = map.get(index);
        }
        for(int i = map.size() -1 ; i >= 0 ;i++){
            System.out.println(i);
        }
    }
}
