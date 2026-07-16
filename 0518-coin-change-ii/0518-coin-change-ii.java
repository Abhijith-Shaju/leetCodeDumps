class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) Arrays.fill(dp[i], -1);

        return helper(amount, 0, coins, dp);
    }

    public int helper( int amt, int index, int[] bills, int[][] dp ){
        if(amt == 0) return 1;
        if(index >= bills.length || amt < 0) return 0;
        if(dp[index][amt] != -1) return dp[index][amt];

        int x = helper(amt - bills[index], index, bills, dp );
        int y = helper(amt, index+1, bills, dp );

        
        dp[index][amt] = x + y;
        return dp[index][amt];
    }
}