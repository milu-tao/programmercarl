package com.milu.work.深信服;

import java.util.*;

public class _3_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        input.trim();

        if(input.equals("")) {
            System.out.println(0);
        }
        String[] split = input.split(" ");


        Set<String> set = new HashSet<>();
        int result = 0;
        int max = 0;
        for(int i = 0; i< split.length;i++){
            if(split[i].equals("")) {
                continue;
            }
            while (i < split.length&&!set.contains(split[i])){
                if(split[i].equals("")) {
                    ;
                }
                result ++;
                set.add(split[i]);
                i++;
            }
            max = Math.max(max,result);
            result =0;
            set.clear();
        }
        System.out.println(max);
    }
}
