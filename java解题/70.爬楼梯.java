/*
 * @Author: fanfan
 * 动态规划
 */
class Solution {
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        for(int i = 0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
        return dp[n];
    }
}