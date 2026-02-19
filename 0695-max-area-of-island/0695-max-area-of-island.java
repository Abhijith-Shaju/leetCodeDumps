class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if( grid[i][j] == 1 ){
                    max = Math.max(max, sink(grid, i, j));
                }
            }
        }
        return max;
    }

    int sink(int[][] grid, int i, int j){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return  sink(grid, i, j + 1) + 
                sink(grid, i, j - 1) + 
                sink(grid, i + 1, j) +
                sink(grid, i - 1, j) +
                1;
    }

}