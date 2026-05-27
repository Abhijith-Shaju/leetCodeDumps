class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // return helper(0, 0, m, n, dp);

        //tabulation

        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int left =  dp[i][j-1];
                int up =  dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }

    int helper(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1)return 1;
        if(i == m || j == n) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        
        dp[i][j] = helper(i+1, j, m, n, dp) + helper(i, j+1, m, n, dp);

        return dp[i][j];
    }


}