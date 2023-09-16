package com.milu.milu.动态规划;

public class _31_718_最长重复子数组 {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength1(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));

    }

    /**
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     *
     * dp[][] : 需要一个二维数组，分别记录两个nums。从前面一些题目延伸过来的，一个数组只能记录一个nums
     * 因此dp[i][j]状态： 以i为结尾的nums1，以j结尾的nums2，公共最长重复子数组长度是dp[i][j]
     * 状态方程：如果nums1[i] == nums2[j]  dp[i-1][j-1] +1
     * 初始化就需要初始化dp[0][j]这种，而在这种，就需要去遍历，nums2在[0,j]中有包含num1[0]的数字就是1，不然就是0.初始化
     *
     * 另一种，我们可以使用dp[i][j]以 i-1 为结尾的nums1，以 j-1 结尾的nums2，公共最长重复子数组长度是dp[i][j]
     * 这样我们0就表示，，那么就可以全部一起初始化成0.比较方便（）
     */
    public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 +1][len2+1];
        int max = 0;
        for(int i = 1; i < len1 +1;i++){
            for(int j = 1 ; j < len2 +1;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 空间压缩
     * 我们可以看到递推公式是dp[i-1][j-1]推过来的，所以只需要保存一个一维数组就行了，
     *
     * 但需要注意从j是从后往前，因为 ,虽然是一维数组，但我们写的时候还是从二维数组的角度去写。
     *
     *
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] dp = new int[len2 +1];
        int max = 0;
        for(int i = 1; i < len1 +1;i++){
            for(int j = len2 ; j > 0;j--){
                if(nums1[i-1] == nums2[j-1]){
                    dp[j] = dp[j-1] +1;
                    max = Math.max(max,dp[j]);
                }else{
                    //一维数组代替二维数组，需要这样子
                    dp[j] = 0;
                }
            }
        }
        return max;

    }

}
