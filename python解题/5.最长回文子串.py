#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#
# https://leetcode-cn.com/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (32.66%)
# Likes:    3061
# Dislikes: 0
# Total Accepted:    449.5K
# Total Submissions: 1.4M
# Testcase Example:  '"babad"'
#
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
# 
# 示例 1：
# 
# 输入: "babad"
# 输出: "bab"
# 注意: "aba" 也是一个有效答案。
# 
# 
# 示例 2：
# 
# 输入: "cbbd"
# 输出: "bb"
# 
# 
# 动态规划

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size < 2:
            return s
        #dp[i][j]代表子串ij
        dp = [[False]*size for _ in range(size)]

        max_len = 1
        start = 0
        #初始化状态空间，单个的值肯定是回文串
        for i in range(size):
            dp[i][i] = True
        #按列更新 i代表头指针，j代表尾指针。
        for j in range(1, size):
            for i in range(0, j):
                if s[i] == s[j]:
                    if j - i < 3:   #等价 j-i+1 < 4 代表s[i][j]长度等于2或者等于3
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                else:
                    dp[i][j] = False
        #每次得到符合条件的子串，记录更新最长长度以及起始位置
                if dp[i][j]:
                    cur_len = j - i + 1
                    if cur_len > max_len:
                        max_len = cur_len
                        start = i
        return s[start:start + max_len]


# @lc code=end

