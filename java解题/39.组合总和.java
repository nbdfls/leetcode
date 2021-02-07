/*
 * @Author: fanfan
 */
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        dfs(candidates, target, ans, com, 0);
        return ans;
    }
    void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> combine,int idx){
        if(idx == candidates.length){
            return;
        }
        if(target==0){
            // 必须新建一个list
            ans.add(new ArrayList<>(combine));
            return;
        }
        //选择不要
        dfs(candidates,target,ans,combine,idx+1);
        //选择要
        if(target>=candidates[idx]){
            //add加入元素
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            // 把加的删了
            combine.remove(combine.size()-1);
        }
    }


}