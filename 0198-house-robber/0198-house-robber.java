class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length-1, dp);
    }

    int helper(int[] nums, int pos, int[] dp){
        if(pos < 0) return 0;

        if(dp[pos] != -1) return dp[pos];

        dp[pos] = Math.max( nums[pos] + helper(nums, pos - 2, dp), helper(nums, pos - 1, dp) );
        
        return dp[pos];
    }
}