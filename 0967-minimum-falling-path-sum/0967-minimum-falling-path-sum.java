class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            
            ans = Math.min(ans, helper(matrix, 0, i, dp, n));

        }
        return ans;
    }

    int helper(int[][] arr, int i, int j, int[][] dp, int n){
        if(j < 0 || j >= n) return 10000;
        if( i >= n ) return 0;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int l = helper(arr, i+1, j-1, dp, n);
        int b = helper(arr, i+1, j, dp, n);
        int r = helper(arr, i+1, j+1, dp, n);

        dp[i][j] = arr[i][j] + Math.min(l, Math.min(b, r));
        return dp[i][j];
    }
}