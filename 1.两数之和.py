#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
# 这里hashmap存的就是遍历过的值的索引，所以当下一次遍历的时候，就会从hash中查找。
#

# @lc code=start 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i,value in enumerate(nums):
            a = target-value
            if a in hashmap:
                return [hashmap[a],i]
            else:
                hashmap[value]=i
        print(hashmap)
        return []
            

        
# @lc code=end

