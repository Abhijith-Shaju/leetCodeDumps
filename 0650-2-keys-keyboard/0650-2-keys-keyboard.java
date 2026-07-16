class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++)Arrays.fill(dp[i], -1);
        return 1 + helper("A", "A", n, dp);
    }

    int helper(String s, String copy, int n, int[][] dp){
        int len1 = s.length();
        int len2 = copy.length();
        if(len1 == n) return 0;
        if(len1 > n) return 10000;
        if(dp[len1][len2] != -1 ) return dp[len1][len2];

        int x = 1 + helper(s+copy, copy, n, dp);
        copy = s;
        int y = 2 + helper(s+copy, copy, n, dp);

        dp[len1][len2] = Math.min(x, y);
        return dp[len1][len2];
    }
}