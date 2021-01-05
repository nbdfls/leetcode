#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个正序数组的中位数
#
# https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
#
# algorithms
# Hard (39.34%)
# Likes:    3568
# Dislikes: 0
# Total Accepted:    312.1K
# Total Submissions: 793.2K
# Testcase Example:  '[1,3]\n[2]'
#
# 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
# 
# 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
# 
# 
# 
# 示例 1：
# 
# 输入：nums1 = [1,3], nums2 = [2]
# 输出：2.00000
# 解释：合并数组 = [1,2,3] ，中位数 2
# 
# 
# 示例 2：
# 
# 输入：nums1 = [1,2], nums2 = [3,4]
# 输出：2.50000
# 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
# 
# 
# 示例 3：
# 
# 输入：nums1 = [0,0], nums2 = [0,0]
# 输出：0.00000
# 
# 
# 示例 4：
# 
# 输入：nums1 = [], nums2 = [1]
# 输出：1.00000
# 
# 
# 示例 5：
# 
# 输入：nums1 = [2], nums2 = []
# 输出：2.00000
# 
# 
# 
# 
# 提示：
# 
# 
# nums1.length == m
# nums2.length == n
# 0 <= m <= 1000
# 0 <= n <= 1000
# 1 <= m + n <= 2000
# -10^6 <= nums1[i], nums2[i] <= 10^6
# 
# 
#

# @lc code=start
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        infinty = 2 ** 40
        m,n = len(nums1),len(nums2)
        # 确定了第一个数组分割线的位置，就能确定第二个数组分割线的位置，因为分割线左侧元素的个数是定值
        left,right = 0,m
        # median1：前一部分的最大值  median2：后一部分的最小值
        median1,median2 = 0,0
         #// 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;         
         # // 两个数组长度之和为偶数时，当在长度之和上+1时，由于整除是向下取整，所以不会改变结果         
         # // 两个数组长度之和为奇数时，按照分割线的左边比右边多一个元素的要求，此时在长度之和上+1，就会被2整除，会在原来的数的基础上+1，于是多出来的那个1就是左边比右边多出来的一个元素
         #  // 在 nums1 的区间 [0, leftLength] 里查找恰当的分割线，使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        while left<=right:
              # 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
              # 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            i =  (left+right) // 2
            j = (m+n+1)//2 -i

            nums_im1 = (-infinty if i==0 else nums1[i-1])
            nums_i = (infinty if i==m else nums1[i])
            nums_jm1 = (-infinty if j==0 else nums2[j-1])
            nums_j = (infinty if j==n else nums2[j])

            if nums_im1 <= nums_j:
                 median1, median2 = max(nums_im1, nums_jm1), min(nums_i, nums_j)                 
                 left = i + 1  
            else:
                right = i - 1
            
        return (median1+median2)/2 if (m+n)%2==0 else median1


# @lc code=end

