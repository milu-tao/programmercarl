package com.milu.work.小米;

import java.util.*;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int freq = in.nextInt();
        String input = in.next();
        String[] split = input.split(",");
        HashMap<Integer, Double> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(String s : split) {
            String[] split1 = s.split(":");
            map.put(Integer.parseInt( split1[0]) , Double.parseDouble( split1[1]));
            list.add(Integer.parseInt( split1[0]));
        }
        list.stream().sorted();

        int cha = Integer.MAX_VALUE;
        int cha_number = 0;
        double result = 0;
        for(int i= 0 ; i < list.size(); i++){
            //
            int newCha =Math.abs(freq - list.get(i));
            if(newCha <= cha) {
                if (cha == newCha) {
                    //一样求均值
                    result = (map.get(list.get(i)) + map.get(cha_number)) / 2;
                } else {
                    cha = newCha;
                    cha_number = list.get(i);
                    result = map.get(cha_number);
                }
            }
        }
        System.out.println(Math.round(result * 10.0) / 10.0);
    }
}
