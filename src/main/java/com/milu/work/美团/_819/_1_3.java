package com.milu.work.美团._819;

import java.util.Scanner;

public class _1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i < n; i++){
            int a = in.nextInt();
            int b = in.nextInt();

            if ((b % a) == 0){
                System.out.println(a);
            }else{
                System.out.println(b % a);
            }
        }
    }
}
