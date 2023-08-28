package com.milu.milu.ACM模式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int c = in.nextInt();
            for (int i = 0; i < c; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a + b);
            }
        }
    }
}
