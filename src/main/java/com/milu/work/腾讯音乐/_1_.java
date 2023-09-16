package com.milu.work.腾讯音乐;

public class _1_ {

    public static void main(String[] args) {
        _1_ v = new _1_();
        System.out.println(v.perfectPair(new int[]{25, 2, 1, 16}));

    }

    public int perfectPair (int[] arr) {
        // write code here
        // 导入不同的数字
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j <arr.length; j++){
                long a = arr[i] * arr[j];
                if(isWan(a)){
                    result ++;
                }
            }
        }
        return result;
    }


    public boolean isWan(long number){
        String number1 = Long.toString(number);
        if(number % Math.pow(10, number1.length()-1) == 0){
            return true;
        }
        return false;
    }
}
