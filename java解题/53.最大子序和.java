class Solution {
    public int maxSubArray(int[] nums) {
        int []dp = new int[nums.length];
        if(nums.length <=0){
            return 0;
        }
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = -1000000;
        for(int i = 0;i<nums.length;i++){
            System.out.print(dp[i]+" ");
            if(res<dp[i]){
                res = dp[i];
            }
        }
        return res;
    }
}