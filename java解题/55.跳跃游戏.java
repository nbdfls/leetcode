/*
 * @Author: fanfan
 */
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 贪心
 * 每一步都维持一个最远到达记录，当到第i个位置，判断最远到达记录是否能达到第I位，如果能，则更新最远到达记录，如果不能，则返回false
 *  动态规划也可
 * dp[i]代表第i位是否可达 
 */

class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach)
                return false;
            else {
                reach = Math.max(reach, i + nums[i]);
            }
        }
        return true;
    }

    public boolean jumpR(int[] nums, int i) {
        int index = nums[i];
        boolean re = false;
        for (int temp = i; temp <= (i + index); temp++) {
            System.out.println(re);
            if (temp > nums.length) {
                break;
            } else {
                if (i + nums[temp] == nums.length) {
                    return true;
                }
                re = jumpR(nums, temp);
            }
        }
        return re;
    }
}
