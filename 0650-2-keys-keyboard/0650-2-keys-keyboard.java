class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        return 1 + helper("A", "A", n, dp);
    }

    int helper(String s, String copy, int n, int[][] dp){
        if(s.length() == n) return 0;
        if(s.length() > n) return 10000;
        if(dp[s.length()][copy.length()] != -1 ) return dp[s.length()][copy.length()];

        int x = 1 + helper(s+copy, copy, n, dp);
        copy = s;
        int y = 2 + helper(s+copy, copy, n, dp);

        dp[s.length()][copy.length()] = Math.min(x, y);
        return dp[s.length()][copy.length()];
    }
}