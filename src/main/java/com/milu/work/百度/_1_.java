package com.milu.work.百度;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n个精灵
        int n = in.nextInt();
        //m个房间
        int m = in.nextInt();
        //k敌人个数
        int k = in.nextInt();

        int[] result = new int[m +1];

        for(int i = 0 ; i < n ; i++){
            int room = in.nextInt();
            int size = in.nextInt();
            if(result[room] == 0){
                result[room] = size;
            }else {
                size = Math.min(size , result[room]);
                result[room] =  size;
            }
        }

        int number = 0;
        for(int i = 0 ; i < result.length; i++){
            number += result[i];
        }

        if(number < k ){
            System.out.println(number);
        }else{
            System.out.println(k);
        }
    }
}
