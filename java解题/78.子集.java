/*
 * @Author: lishui fan
 * @Date: 2021-02-08 11:22:06
 * @LastEditors: your name
 * @LastEditTime: 2021-03-10 14:08:51
 * @Description: 回溯
 */

// @lc code=start
import java.util.*;

class Solution {
    // public static void main(String[] args){
    //     Solution1 s = new Solution1();
    //     int[] nums = {1,2,3};
    //     s.subsets(nums);
        
    // }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for(int i = 0;i<=nums.length;i++){
            dfs(nums, res, temp, used, i, 0);
        }
        return res;

    }
    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> temp,boolean[] used,int depth,int index){
        if(depth == 0){
            res.add(new ArrayList<>());
            return;
        }
        if(temp.size() == depth){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(used[i]==false){
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, res, temp, used, depth,i+1);
                used[i] = false;
                temp.remove(temp.lastIndexOf(nums[i]));
            }
        }
    }

}
// @lc code=end

