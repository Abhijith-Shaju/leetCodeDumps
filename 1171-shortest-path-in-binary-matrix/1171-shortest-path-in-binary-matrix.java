class Solution {
    class pair{
        int a;
        int b;
        int d;
        pair(int a, int b, int d){
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m-1][n-1] == 1) return -1;
        if((n == 1 && m == 1) && grid[0][0] == 0) return 1;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0, 0, 1));

        //the eight directions
        int[][] dirs =  {   {1,-1}, {1,0}, {1,1}, // top
                            {0,-1}, {0,1}, // mid
                            {-1,-1}, {-1, 0}, {-1, 1} }; //bottom


        while( !q.isEmpty() ){
            int i = q.peek().a;
            int j = q.peek().b;
            int dist = q.peek().d;

            q.poll();

            for(int[] dir : dirs){
                int a = dir[0], b = dir[1];

                if(i+a == m-1 && j+b == n-1) return dist+1;

                if( i+a < m && i+a >= 0 && j+b < n && j+b >= 0 && grid[i+a][j+b] == 0){
                    q.offer(new pair(i+a, j+b, dist+1));
                    grid[i+a][j+b] = 1;
                } 
            }
        }
        return -1;
    }
}