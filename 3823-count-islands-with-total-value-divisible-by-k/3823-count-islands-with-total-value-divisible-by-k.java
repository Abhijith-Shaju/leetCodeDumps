class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;

        int n = grid.length, m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if( grid[i][j] != 0 ){
                    long temp = helper(grid, i, j, n, m);
                    if(temp % k == 0 && temp != 0) ans++;
                }
            }
        }
        return ans;
    }

    long helper(int[][] grid, int i, int j, int n, int m){
        if( i < 0 || j < 0 || i >= n || j >= m || grid[i][j] <= 0 ) return 0;

        long sum = grid[i][j];
        grid[i][j] = 0;

        return sum + helper(grid, i + 1, j, n, m) +
                     helper(grid, i - 1, j, n, m) +
                     helper(grid, i, j + 1, n, m) +
                     helper(grid, i, j - 1, n, m);      
    }
}