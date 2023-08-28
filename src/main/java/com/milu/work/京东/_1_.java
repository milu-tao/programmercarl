package com.milu.work.京东;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        int[] result = new int[n];
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n; i ++){
            int start = 0;
            if(nums[i] > Integer.MAX_VALUE/2){
                start = Integer.MAX_VALUE/2;
            }else{
                start = 1;
            }
            for(int j = start; j < Integer.MAX_VALUE && i < n; j++){
                if(set.contains(j)){
                    continue;
                }else{
                    if( (j + nums[i]) % (i+1) == 0){
                        set.add(j);
                        result[i] = j;
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
        for(int i = 0 ; i< n; i++){
            if(i == n -1){
                System.out.println(result[i]);
            }else{
                System.out.print(result[i]+ " ");
            }
        }
    }
}
