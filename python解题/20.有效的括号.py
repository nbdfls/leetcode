#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
# 不用栈，用正则表达式匹配就行。

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        if len(s)==0: return True
        def match(s1,s2):
            if s1=='(' and s2==')': return True
            elif s1=='[' and s2==']': return True
            elif s1=='{' and s2=='}': return True
            else: return False
        for i in range(len(s)):
            if(s[i]=='(' or s[i]=='[' or s[i]=='{'):
                stack.append(s[i])
            else:
                if (len(stack)==0 and (s[i]=='}' or s[i]==']' or s[i]==')')):
                    return False
                if match(stack[-1],s[i]):
                    stack.pop()
                else:
                    return False
        if(len(stack)==0):return True
        else : return False
            


# @lc code=end

