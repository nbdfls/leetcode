/*
 * @Author: fanfan
 */
/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */
/* 
    动态规划解法：
        状态空间dp[i]，代表字符串中第i位代表的最长有效括号长度
        当dp[i] == '(' 不需要讨论，因为这个计算最长有效括号为0
        当dp[i] == ')' 针对dp[i-1] 展开讨论
            dp[i-1] == '('  则 dp[i] = dp[i-2] + 2;
            dp[i-1] == ')' 且 dp[i-dp[i-1]-1]=='(' 则 dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2]
            因为当do[i-1]是一个有效子字符串的一部分（记作 sub），对于最后一个‘）’ ，如果它是一个更
            长子字符串的一部分，那么它一定有一个对应的‘(’ ，且它的位置在倒数第二个‘)’ 所在的有效子字
            符串的前面（也就是 sub的前面）
    栈解法：
        用栈模拟一遍，将所有无法匹配的括号的位置全部置1
        例如: "()(()"的mark为[0, 0, 1, 0, 0]
        再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
        经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
*/ 

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];

        for(int i = 1;i<s.length();++i){
            if(s.charAt(i)==')'){
                if(s.charAt(i)==')'&&s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }
                else if(s.charAt(i)==')'&&s.charAt(i-1)==')'){
                    if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i] = dp[i-1]+2+(i-dp[i-1]>=2?dp[i-dp[i-1]-2]:0);
                    }
                }
                maxans = dp[i]>maxans?dp[i]:maxans;
            }
        }

        return maxans;
    }
}
// @lc code=end

