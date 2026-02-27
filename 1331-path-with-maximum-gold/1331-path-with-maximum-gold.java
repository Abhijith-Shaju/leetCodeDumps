class Solution {
    public int getMaximumGold(int[][] grid) {
        int max[] = {0};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                helper(grid, i, j, 0, max, new int[grid.length][grid[0].length]);
            }
        }

        return max[0];
    }

    void helper(int[][] grid, int i, int j, int sum, int[] max, int[][] visited){
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || visited[i][j] == 1 || grid[i][j] == 0) return;


        sum += grid[i][j];
        visited[i][j] = 1;
        max[0] = Math.max(max[0], sum);

        helper(grid, i+1, j, sum, max, visited);
        helper(grid, i-1, j, sum, max, visited);
        helper(grid, i, j+1, sum, max, visited);
        helper(grid, i, j-1, sum, max, visited);

        visited[i][j] = 0;
    }
}