package com.milu.work.百度;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _2_ {


    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('r', 1);
        map.put('w', 2);
        map.put('x', 4);

        int[] result = new int[3];
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        char[] chars = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            int number = 0;
            if (chars[i * 3] != '-') {
                number += 1;
            }
            if (chars[i * 3 + 1] != '-') {
                number += 2;
            }
            if (chars[i * 3 + 2] != '-') {
                number += 4;
            }
            result[i] = number;
        }

        int number = Integer.valueOf(in.nextLine());


        for (int i = 0; i < number; i++) {
            //chmod ug+rw baidu.txt
            String nextLine = in.nextLine();
            String[] strings = nextLine.split(" ");
            if (strings[1].contains("=")) {
                String[] split = strings[1].split("=");
                String s1 = split[1];
                int stringss = 0;
                for (char c : s1.toCharArray()) {
                    stringss += map.get(c);
                }
                for (char c : split[0].toCharArray()) {

                    if (c == 'u') {
                        result[0] = stringss;
                    }
                    if (c == 'g') {
                        result[1] = stringss;
                    }
                    if (c == 'o') {
                        result[2] = stringss;
                    }
                    if (c == 'a') {
                        result[0] = stringss;
                        result[1] = stringss;
                        result[2] = stringss;
                    }
                }
            } else if (strings[1].contains("-")) {
                String[] split = strings[1].split("-");
                String s1 = split[1];
                int stringss = 0;
                for (char c : s1.toCharArray()) {
                    stringss += map.get(c);
                }

                for (char c : split[0].toCharArray()) {

                    if (c == 'u') {
                        result[0] = result[0] - stringss;
                    }
                    if (c == 'g') {
                        result[1] = result[1] - stringss;
                    }
                    if (c == 'o') {
                        result[2] = result[2] - stringss;
                    }
                    if (c == 'a') {
                        result[0] = result[0] - stringss;
                        result[1] = result[1] - stringss;
                        result[2] = result[2] - stringss;
                    }
                }

            }else{
                String[] split = strings[1].split("\\+");
                String s1 = split[1];
                int stringss = 0;
                for (char c : s1.toCharArray()) {
                    stringss += map.get(c);
                }

                for (char c : split[0].toCharArray()) {

                    if (c == 'u') {
                        result[0] = result[0] + stringss;
                    }
                    if (c == 'g') {
                        result[1] = result[1] + stringss;
                    }
                    if (c == 'o') {
                        result[2] = result[2] + stringss;
                    }
                    if (c == 'a') {
                        result[0] = result[0] + stringss;
                        result[1] = result[1] + stringss;
                        result[2] = result[2] + stringss;
                    }
                }
            }


        }

        for(int i = 0 ; i < 3 ; i++){
            if(result[i]==0){
                System.out.print("---");
            }
            if(result[i]==1){
                System.out.print("r--");
            }
            if(result[i]==2){
                System.out.print("-w-");
            }
            if(result[i]==3){
                System.out.print("rw-");
            }
            if(result[i]==4){
                System.out.print("--x");
            }
            if(result[i]==5){
                System.out.print("r-x");
            }
            if(result[i]==6){
                System.out.print("-wx");
            }
            if(result[i]==7){
                System.out.print("rwx");
            }
        }

    }
}
