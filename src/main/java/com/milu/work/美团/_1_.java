package com.milu.work.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(in.nextInt());
        }
        int target1 = in.nextInt();
        int target2 = in.nextInt();

        if(isxiangling(list,target1,target2)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean isxiangling(List<Integer> list, int target1, int target2) {
        //定位target的位子
        int targetIndex = 0;
        for(int i = 0; i < list.size();i++){
            if(list.indexOf(i) == target1 || list.indexOf(i) == target2 ){
                targetIndex = i;
                break;
            }
        }
        if(targetIndex -1 >=0 && (list.get(targetIndex - 1) == target2 || list.get(targetIndex -1) ==target1)){
            return true;
        }
        if(targetIndex +1 < list.size() && (list.get(targetIndex + 1) == target2 || list.get(targetIndex +1) == target1)){
            return true;
        }
        return false;
    }


}
