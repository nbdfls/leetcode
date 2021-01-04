/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        Vector<int> res = new Vector<int>();
        for(int i = 0;i<nums.size();i++)
        {
            int a = target - nums[i];
            if(nums.contains(a)){
                res.add(i);
                res.add(nums.indexOf(a));
                return res;
            }

        }
    }
};
// @lc code=end

