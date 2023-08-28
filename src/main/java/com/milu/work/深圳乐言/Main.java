package com.milu.work.深圳乐言;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //测试数据
        String s1 = "XXYYYXZ"; //X:3 Y:3 Z:1
        String s2 = "ZZZXXYXY"; // X:3 Y:2 Z:3
        String s3 = "ZZZZYYXZZXZZXZZYYXZZXZZXZZXX"; // X:8 Y:4 Z:16

        getWord(s1);
        getWord(s2);
        getWord(s3);
    }
    /**
     *  写一个函数用来统计字符串中各字母出现的次数
     *
     *  思路：用一个字典进行统计
     */
    private static void getWord(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                //存在
                map.put(c,map.get(c)+1);
            }else{
                //不存在
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}
