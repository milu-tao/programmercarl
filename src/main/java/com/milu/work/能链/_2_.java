//package com.milu.work.能链;
//
//import javax.xml.stream.FactoryConfigurationError;
//
//public class _2_ {
//    public static void main(String[] args) {
//        //["XYZE","SFZS","XDEE"],"XYZZED"
//        System.out.println(exist(new String[]{"XYZE", "SFZS", "XDEE"}, "XYZZED"));
//        //["XYZE","SFZS","XDEE"],"XYZY" false
//        System.out.println(exist(new String[]{"XYZE", "SFZS", "XDEE"}, "XYZY"));
//        //["XYZE","SFZS","XDEE"],"SEE"
//        System.out.println(exist(new String[]{"XYZE", "SFZS", "XDEE"}, "SEE"));
//
//
//
//    }
//
//
//    public static boolean exist (String[] board, String word) {
//        /**
//         *  dp[][][] : 第k的字母前，dp【】【】是的子串状态是dp[][]
//         *  并且定义二维数组记录字母是否用过
//         */
//        //处理String
//        char[][] input = new char[board.length][board[0].length()];
//        for(int j = 0 ; j < input.length; j++){
//            char[] c = board[j].toCharArray();
//            for(int i = 0; i < c.length; i++){
//                input[j][i] = c[i];
//            }
//        }
//
//
//        //dp[][][] : 第k的字母前，dp【】【】是的子串状态是dp[][]
////        boolean[][][] dp = new boolean[board.length][board[0].length()][word.length()];
//        boolean[][][] dp = new boolean[word.length()][board.length][board[0].length()];
//
//        //先不考虑
//        boolean[][][] used = new boolean[word.length()][board.length][board[0].length()];
//
//        char w1 = word.charAt(0);
//        //初始化
//        for(int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length(); j++) {
//                if(w1 == input[i][j]){
//                    dp[0][i][j] = true;
//                    used[0][i][j] = true;
//                }
//            }
//        }
//
//        for(int k = 1 ; k <word.length();k++){
//            for(int i = 0; i < board.length; i++){
//                for(int j = 0 ; j < board[0].length();j++){
//                    if(input[i][j] == word.charAt(k)){
//                        if((i-1 >= 0 && !used[k][i-1][j] && dp[k-1][i-1][j] == true)){
//                            used[k][i-1][j] = true;
//                            dp[k][i][j] = true;
//                        }
//                        if((j-1 >=0 && !used[k][i][j-1]   && dp[k-1][i][j-1] == true)){
//                            used[k][i][j-1] = true;
//                            dp[k][i][j]=true;
//                        }
//                        if(i+1 < board.length && !used[k][i+1][j] && dp[k-1][i+1][j] == true ){
//                            used[k][i+1][j] = true;
//                            dp[k][i][j]=true;
//                        }
//                        if( j+1 < board[0].length() && !used[k][i][j+1] && dp[k-1][i][j+1] ==true){
//                            used[k][i][j+1] = true;
//                            dp[k][i][j]=true;
//                        }
//                    }
//                }
//            }
//        }
//
////        for(int k = 1 ; k <word.length();k++){
////            for(int i = 0; i < board.length; i++){
////                for(int j = 0 ; j < board[0].length();j++){
////                    if(input[i][j] == word.charAt(k) &&
////                            used[k][i][j] == false &&
////                            ((i-1 >= 0 && dp[k-1][i-1][j] == true) ||
////                            (j-1 >=0 && dp[k-1][i][j-1] == true) ||
////                            (i+1 < board.length && dp[k-1][i+1][j] == true ) ||
////                            ( j+1 < board[0].length() && dp[k-1][i][j+1] ==true))
////                    ){
////                        used[k][i][j] = true;
////                        dp[k][i][j] = true;
////                    }
////                }
////            }
////        }
//
//        for(int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length(); j++) {
//                if(dp[word.length()-1][i][j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     *  dp[][][] : 第k的字母前，dp【】【】是的子串状态是dp[][]
//     *  并且定义二维数组记录字母是否用过
//     */
//    //处理String
//    char[][] input = new char[board.length][board[0].length()];
//        for (int j = 0 ; j < input.length; j++) {
//        char[] c = board[j].toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            input[j][i] = c[i];
//        }
//    }
//
//}
