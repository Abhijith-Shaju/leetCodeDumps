class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return helper(0, 0, m, n, obstacleGrid, dp);
    }

    int helper(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if( i == m || j == n || grid[i][j] == 1 ) return 0;
        
        if(i == m-1 && j == n-1)return 1;

        if(dp[i][j] != 0)return dp[i][j];
        dp[i][j] = helper(i+1, j, m, n, grid, dp) + helper(i, j+1, m, n, grid, dp);

        return dp[i][j];
    }
}