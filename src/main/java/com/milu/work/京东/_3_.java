package com.milu.work.京东;

import javafx.scene.media.EqualizerBand;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _3_ {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        int n = in.nextInt(),m= in.nextInt();
        Map<Integer , int[]> map = new LinkedHashMap<>();
        for(int i = 0; i < n ; i++){
            String st = in.next();
            int power = in.nextInt();
            if("human" .equals(st)){
                map.put(i + 1 , new int[]{0,power});
            }else {
                map.put(i + 1, new int[]{1, power});
            }
        }
        for(int i = 0; i < m; i++){
            int x = in.nextInt() , y = in.nextInt();
            String x1 = in.next(), x2 = in.next();
            int[] p1 = map.get(x),p2 = map.get(y);
            if(p1[0] ==0){
                if(p2[0] ==1){
                    if("Y".equals(x1)){
                        if(p1[1] > p2[1]){
                            map.remove(y);
                        }else if( p1[1]< p2[1]){
                            map.remove(x);
                        }
                    }else{
                        if("Y".equals(x2)){
                            if(p1[1] > p2[1]){
                                map.remove(y);
                            }
                        }
                    }
                }
            }else{
                if( p2[0] ==0){
                    if("Y" .equals(x2)){

                    }
                }
            }
        }
    }
}
