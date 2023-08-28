package com.milu.work.美团;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _2_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = new LinkedList<>();
        int len = in.nextInt();
        for(int i =0; i < len;i ++){
            list.add(in.nextInt());
        }

        int start = in.nextInt();
        int end = in.nextInt();
        //
//        list.add(1);
//        list.add(2);
//        list.add(2);
//
//        int start = 1;
//        int end = 2;

        System.out.println(juli(list, start, end));
    }

    private static int juli(List<Integer> list, int start, int end) {
        //往前
        int juli_qian = 0;
        //&& i < 2 * list.size()
        for(int i = start ; i != end ; i++){
            if(i == list.size()-1 ){
                i = 0;
            }
            juli_qian += list.get(i);
        }
        int juli_hou = 0;
        int i= start;
        while (i != end){

            juli_hou += list.get(i-1);
            juli_hou += list.get(i-1);
            i--;
            if(i == 0){
                i = list.size() -1;
            }
        }
        return Math.min(juli_qian,juli_hou);
    }
}
