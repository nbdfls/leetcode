/*
 * @Author: fanfan
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums,temp,0,res,used);
        
        return res;
    }
    public void dfs(int[] nums,List<Integer> temp,int index,List<List<Integer>> res,boolean[]used){
        if(index >= nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]==false){
                temp.add(nums[i]);
                used[i]=true;
                dfs(nums, temp, index+1, res, used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }

        }

    }
}