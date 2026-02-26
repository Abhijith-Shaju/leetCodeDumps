class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) sink(i, 0, grid);
            if(grid[i][n-1] == 1) sink(i, n-1, grid);
        }

        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1) sink(0, i, grid);
            if(grid[m-1][i] == 1) sink(m-1, i, grid);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) ans++;
            }
        }

        return ans;
    }

    void sink(int i, int j, int[][] grid){
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0) return ;
        grid[i][j] = 0;

        sink(i+1, j, grid);
        sink(i-1, j, grid);
        sink(i, j+1, grid);
        sink(i, j-1, grid);

    }
}