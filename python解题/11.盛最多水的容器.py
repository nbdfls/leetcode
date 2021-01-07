#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxA = 0
        for i in range(len(height)-1):
            numi = height[i]
            for j in range(i+1,len(height)):
                numj = height[j]
                area = min(numi,numj)*(j-i)
                maxA = max(maxA,area)
        return maxA
# @lc code=end

