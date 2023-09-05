package com.milu.work.blbl;

public class _2_ {
    public static void main(String[] args) {
        System.out.println(minDeleteSum("eat", "sea")); //231
    }
    public static int minDeleteSum (String s1, String s2) {


        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == 0){
            int result = 0;
            for(int i = 0; i <len2;i++){
                result += s2.charAt(i);
            }
            return result;
        }

        if(len2 == 0){
            int result = 0;
            for(int i = 0; i <len1;i++){
                result += s1.charAt(i);
            }
            return result;
        }
        //dp
        int[][] dp = new int[len1 +1][len2 + 1];

        //初始化
        for(int i = 1 ; i <= len1 ;  i++) {
            dp[i][0] += s1.charAt(i - 1);
        }
        for(int j = 1 ; j <= len2;  j++) {
            dp[0][j] += s2.charAt(j - 1);
        }

        //遍历顺序 i : s1  ; j : s2
        for(int i = 1 ; i <= len1;i ++ ){
            for(int j =1 ; j <= len2; j++){
                if(s1.charAt(i -1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1] + s1.charAt(i-1) +s2.charAt(j-1),Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1)));
                }
            }
        }
        return dp[len1][len2];
    }
}
