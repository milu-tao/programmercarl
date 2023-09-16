package com.milu.work.去哪儿;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class _2_ {

    public static void main(String[] args) {
//        int[] ints = new int[Integer.MAX_VALUE];
        System.out.println(find(9, 2, new int[]{1, 1,1,1,1,1, 4, 4,}));
//        System.out.println(find(Integer.MAX_VALUE, 0 ,ints));
    }

    public static int find (int n, int v, int[] a) {
        int min = 0;
        int max = n - 1;
        int mid = 0;
        int index = -1;
        while (min < max) {
            mid = (min + max) / 2;
            if(a[mid] > v){
                max = mid-1;
            }else if(a[mid] < v){
                min = mid +1;
            }else{
                max = mid;
                index = mid;
            }
        }
        return index == -1 ? a.length +1:index+1;
    }

}
