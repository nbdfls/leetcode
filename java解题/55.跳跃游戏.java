/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
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
