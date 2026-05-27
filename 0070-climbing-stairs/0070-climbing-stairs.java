class Solution {
    //memoization
    // public int climbStairs(int n) {        
    //     int[] dp = new int[n+1];

    //     return helper( n, dp );
    // }

    // int helper(int n, int[] dp){
    //     if( n <= 2 ) return n;

    //     if( dp[n] != 0 ) return dp[n];
    //     dp[n] = helper( n - 1, dp ) + helper( n - 2, dp );

    //     return dp[n];
    // }

    //tabulation
    // public int climbStairs(int n) {        
    //     if( n <= 2 ) return n;

    //     int[] dp = new int[n+1];
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for(int i = 3; i <= n; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }

    //     return dp[n];
    // }

    //direct approach?? faster and better??
    public int climbStairs(int n) {        
        if( n <= 2 ) return n;

        // int[] dp = new int[n+1];
        int temp1 = 1;
        int temp2 = 2;
        int temp3 = 0;

        for(int i = 3; i <= n; i++){
            temp3 = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp3;
        }

        return temp3;
    }
}