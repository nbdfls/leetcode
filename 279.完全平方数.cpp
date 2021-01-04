/*
 * @lc app=leetcode.cn id=279 lang=cpp
 *
 * [279] 完全平方�?
 */
#define INF 0x7fffff
class Solution {
public:
    int numSquares(int n) {
        if (n <= 0)
        {
            return 0;
        }
      //  int col = sqrt(n);
        int dp[n+1];
        for(int i = 1;i<=n;i++){
          //  dp[1][i] = 1;
            dp[i] = INF;
        }
        // for(int i = 0;i<=n;i++){
        //   //  dp[i][1]=i;
        //     dp[i][0] = 0;
        // }
        dp[0] = 0;
       // dp[1][1] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=floor(sqrt(i));j++){
              //  if(dp[i][j]==)
                dp[i]=min(dp[i-j*j]+1,dp[i]);
            }
        }
        for(int i = 0;i<n;i++){
           
                cout<<dp[i]<<" ";
            
            
        }
        return dp[n];
    }
};

