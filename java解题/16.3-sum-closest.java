import java.util.ArrayList;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.49%)
 * Total Accepted:    297K
 * Total Submissions: 714.5K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[nums.length-1];
        for(int i = 0;i<nums.length-2;i++)
        {
            int nl = i+1,nr = nums.length-1;
            int sum = 0;
            while(nl<nr)
            {
                sum = nums[i]+nums[nl]+nums[nr];
                if(sum<target)
                {
                    nl++;
                }
                else if(sum>target){
                    nr--;
                }else{

                    while(nl<nr&&nums[nl]==nums[nl+1])nl++;
                    while(nl<nr&&nums[nr]==nums[nr-1])nr--;
                    nl++;
                    nr--;
                }
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res = sum;
                }

            }

        }

        return res;
        
        
    }
}

