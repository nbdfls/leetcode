import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            int a = nums[i];
            if(temp.containsKey(a)){
                int right = i;
                int left = temp.get(a);
                return new int[]{left,right};
            }else{
                temp.put(target-a, i);
            }
        }
        
        return res;
    }
}

