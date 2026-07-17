class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];
        
        // FIXED: Using Math.max so health never drops below 1
        dp[n-1][m-1] = Math.max(1, 1 - dungeon[n-1][m-1]);

        // FIXED: Iterating m-2 for columns, subtracting dungeon value
        for(int i = m-2; i >= 0; i--) 
            dp[n-1][i] = Math.max(1, dp[n-1][i+1] - dungeon[n-1][i]);
        
        // FIXED: Iterating n-2 for rows, subtracting dungeon value
        for(int i = n-2; i >= 0; i--) 
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - dungeon[i][m-1]);

        // Your inner loops are perfect!
        for(int i = n - 2; i >= 0; i--){
            for(int j = m - 2; j >= 0; j--){
                int room = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(1, room - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}