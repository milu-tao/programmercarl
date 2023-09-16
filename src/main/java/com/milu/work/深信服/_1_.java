package com.milu.work.深信服;

import java.util.Scanner;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int x = in.nextInt();
//        int y = in.nextInt();
        int x = 7;
        int y = 3;
        if(y == 0){ System.out.println(1);}

        int result = x;
        for(int z = 0; z < y -1; z++){
            result=result * x;
            result = result % 10;
        }

        System.out.println(result);
    }
}
