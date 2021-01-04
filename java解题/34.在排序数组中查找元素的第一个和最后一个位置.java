/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] re = new int[2];
        if (nums.length <= 0 || nums == null) {
            return new int[] { -1, -1 };
        }
        int start = 0, end = nums.length - 1;
        // left
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start + "" + end);
        if (nums[start] == target) {
            re[0] = start;
        } else {
            return new int[] { -1, -1 };
        }

        end = nums.length - 1;

        // right
        while (start < end) {
            int mid = (start + end) / 2 + 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        System.out.println(start + "" + end);
        if (nums[start] == target) {
            re[1] = start;
        } else {
            return new int[] { -1, -1 };
        }
        return re;

    }
}
