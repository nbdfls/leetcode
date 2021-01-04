/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.69%)
 * Total Accepted:    380.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        
        int bp = 0;
        bp = findBreakPoint(nums);
        
        if(nums[0]>target){
             return binarySearch(nums, target, bp, nums.length-1);
        }else{
             return binarySearch(nums, target, 0, bp);
        }
        
    }
    private int findBreakPoint(int[] nums){
        int lo = 0, hi = nums.length-1, temp = nums[0];
        int breakPointIndex = 0;
        while(lo+1<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>=temp){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        breakPointIndex = nums[lo]>temp?lo:hi;        
        System.out.print(breakPointIndex);

        return breakPointIndex;
    }
    private int binarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start = mid+1;
            }
            else if (nums[mid]>target){
                end = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
        
    }
}

