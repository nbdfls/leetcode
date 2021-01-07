#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
# 双指针法:当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        numsLen = len(nums)
        ans = []
        # 枚举 a 
        for first in range(numsLen):
            if nums[first]>0:
                return ans
            # 跳过相邻重复元素！
            if first>0 and nums[first]==nums[first-1]:
                continue
            #target: -nums[first] 是定值，在这个定值之上，使用双指针法，由于
            #排序之后，L增大，R必然要减小
            L = first+1
            R = numsLen - 1
            while(L<R):
                if(nums[first]+nums[R]+nums[L]==0):
                    ans.append([nums[first],nums[L],nums[R]])
                    # 去除重复解
                    while(L<R and nums[L]==nums[L+1]):
                        L+=1
                    while(L<R and nums[R]==nums[R-1]):
                        R-=1
                    L+=1
                    R-=1
                elif nums[first]+nums[L]+nums[R]>0:
                    R=R-1
                else:
                    L=L+1
        return ans


# @lc code=end

