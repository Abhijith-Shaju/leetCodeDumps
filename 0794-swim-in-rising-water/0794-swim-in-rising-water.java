class Solution {
    class Pair{
        int i;
        int j;
        int reqElevation;
        Pair(int i, int j, int reqElevation){
            this.i = i;
            this.j = j;
            this.reqElevation = reqElevation;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> a.reqElevation - b.reqElevation );
        pq.offer(new Pair(0, 0, grid[0][0]));

        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while( !pq.isEmpty() ){
            Pair p = pq.poll();
            if(p.i == n-1 && p.j == n-1) return p.reqElevation;
            
            if(visited[p.i][p.j])continue;
            visited[p.i][p.j] = true;

            for( int[] dir : dirs ){
                int i = p.i + dir[0];
                int j = p.j + dir[1];

                if( i >= 0 && j >= 0 && i < n && j < n) {
                    if( grid[i][j] <= p.reqElevation ){
                        pq.offer(new Pair(i, j, p.reqElevation));
                    }else{
                        pq.offer(new Pair(i, j, grid[i][j]));
                    }
                }
            }
        }
        return 0;
    }
}