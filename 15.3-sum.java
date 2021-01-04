import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.56%)
 * Total Accepted:    497.4K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res =  new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++)
        {
            int nl = i+1,nr = nums.length-1,sum = 0-nums[i];
            while((i==0&&nl<nr) || (nl<nr&&nums[i]!=nums[i-1]))
            {
                if(nums[nr]+nums[nl]==sum) 
                {  
                    res.add(Arrays.asList(nums[i],nums[nl],nums[nr]));
                    while(nl<nr&&nums[nr]==nums[nr-1]) nr--;
                    while(nl<nr&&nums[nl]==nums[nl+1]) nl++;
                    nl++;
                    nr--;
                    
                }else if(nums[nr]+nums[nl]<sum)
                {
                    nl++;
                }
                else{
                    nr--;
                }
                
            }
        }
        return res;
}}

