/*
 * @Author: lishui fan
 * @Date: 2021-03-10 10:59:44
 * @LastEditors: your name
 * @LastEditTime: 2021-03-10 11:22:46
 * @Description:  动态规划 D[i][j]代表字符串A前i个字符和字符串B前j个字符之间的距离，只需要获取 D[i][j-1],D[i-1][j],D[i-1][j-1]即可
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n*m==0){
            return n+m;
        }
        int [][]D = new int[n+1][m+1];
        for(int i = 0;i<n+1;i++){
            D[i][0]=i;
        }
        for(int j = 0;j<m+1;j++){
            D[0][j]=j;
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                int left = D[i-1][j]+1;
                int down = D[i][j-1]+1;
                int left_down = D[i-1][j-1];   //这里的D[i-1][j-1]代表的是字符串前i-1和j-1，因为D代表的字符串索引是从1开始算得
                if(word1.charAt(i-1)!=word2.charAt(j-1)){ //这里的i-1和j-1代表字符串前i和前j，这里字符串索引是从0开始算得
                    left_down+=1;
                }
                D[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return D[n][m];
    }
}
// @lc code=end

