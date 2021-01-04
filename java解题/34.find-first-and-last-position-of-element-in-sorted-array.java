/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.06%)
 * Total Accepted:    275.9K
 * Total Submissions: 833.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ps,pe;
        ps = minBinarySearch(nums, target, 0, nums.length-1);
        pe = maxBinarySearch(nums, target, 0, nums.length-1);
        if(ps==-1) return new int[]{-1,-1};
        else{
            return new int[]{ps,pe};
        }
        
    }
    public int minBinarySearch(int[] nums,int target,int start,int end)
    {
        int index = 0,mid = (start+end)/2;
        while(start<=end){
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                while(nums[mid]==target) mid--;
                mid++;
                return mid;
            }
        }
        return -1;
    }
    public int maxBinarySearch(int[] nums,int target,int start,int end)
    {
        int index = 0,mid = (start+end)/2;
        while(start<=end){
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                while(nums[mid]==target) mid++;
                mid--;
                return mid;
            }
        }
        return -1;
    }
}

