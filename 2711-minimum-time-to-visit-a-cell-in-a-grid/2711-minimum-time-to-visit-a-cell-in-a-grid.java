class Solution {
    class Pair{
        int i;
        int j;
        int time;
        Pair(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    public int minimumTime(int[][] grid) {
        if(grid[1][0] > 1 && grid[0][1] > 1) return -1;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] arr = new boolean[n][m];

        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b)-> a.time-b.time );
        pq.offer(new Pair(0, 0, 0));

        while( !pq.isEmpty() ){
            Pair p = pq.poll();

            if(p.i == n-1 && p.j == m-1) return p.time;
            if(arr[p.i][p.j]) continue;
            arr[p.i][p.j] = true;

            for(int[] dir: dirs){
                int i = p.i + dir[0];
                int j = p.j + dir[1];

                if( i >= 0 && j >= 0 && i < n && j < m && !arr[i][j]){
                    if(1 + p.time >= grid[i][j]){
                        pq.offer(new Pair(i, j, 1+p.time));
                    }else{
                        int diff = grid[i][j] - p.time;
                        pq.offer(new Pair(i, j, grid[i][j] + (diff%2 == 0 ? 1 : 0)));
                    }
                }
            }
        }
        return -1;
    }
}