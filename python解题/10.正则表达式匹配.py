#
# @lc app=leetcode.cn id=10 lang=python3
#
# [10] 正则表达式匹配
#

# @lc code=start
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if not p : return not s
        if not s and len(p)==1: return False

        mrow,ncol = len(s)+1,len(p)+1
        #这里dp[0][0]代表空字符串，并不是索引第一个字符
        dp = [[False for c in range(ncol)] for r in range(mrow)]
        #边界条件，空字符串相同
        dp[0][0] = True
        dp[0][1] = False
        for c in range(2,ncol):
            j = c - 1
            if p[j] == '*':
                dp[0][c] = dp[0][c-2]

        #状态转移方程
        # 如果 p[j] == s[i] : dp[i][j] = dp[i-1][j-1]；
        # 如果 p[j] == '.' : dp[i][j] = dp[i-1][j-1]；
        # 如果 p[j] == '*'：
            # 如果 p[j-1] != s[i] : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
            # 如果 p[i-1] == s[i] or p[i-1] == '.'：
                # dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
                # or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
                # or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty

        for r in range(1,mrow):
            i = r-1
            for c in range(1,ncol):
                j = c-1
                if s[i]==p[j] or p[j] =='.':
                    dp[r][c] = dp[r-1][c-1]
                elif p[j]=='*':
                    if p[j-1]==s[i] or p[j-1]=='.':
                        dp[r][c] = dp[r-1][c] or dp[r][c-2]
                    else:
                        dp[r][c] = dp[r][c-2]
                else:
                    dp[r][c] = False
        return dp[mrow-1][ncol-1]


        

# @lc code=end

