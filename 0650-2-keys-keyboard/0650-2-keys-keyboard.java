class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++)Arrays.fill(dp[i], -1);

        return 1 + helper(1, 1, n, dp);
    }

    int helper(int s, int copy, int n, int[][] dp){
        if(s == n) return 0;
        if(s > n) return 10000;

        if(dp[s][copy] != -1 ) return dp[s][copy];

        int x = 1 + helper(s+copy, copy, n, dp);

        int y = 2 + helper(s+s, s, n, dp);

        dp[s][copy] = Math.min(x, y);
        return dp[s][copy];
    }
}