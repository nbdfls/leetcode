#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
# 深度优先搜索  递归实现
# 广度优先搜索  队列实现

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        l=['','','abc','def','ghi','jkl','mno','pqrs','tuv','wxyz']
        ans = []
        st = ''
        def addLetter(oriSt,index):
            index+=1
            if index>=len(digits):  
                return ans
            st = l[int(digits[index])]
            strLen = len(st)
            
            for i in range(strLen):
                temp = oriSt.__add__(st[i])
                
                if(index==(len(digits)-1)):
                    ans.append(temp)
                print(temp,index)
                
                addLetter(temp,index)
            
        addLetter(st,-1)
        return ans
       # @lc code=end

