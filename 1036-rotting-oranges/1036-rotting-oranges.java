class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int ans = 0;
        
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){ 
                    q.offer(new Pair(i, j));
                }else if(grid[i][j] == 1) fresh++;
            }
        }
        
        int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while( !q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();

                for(int[] dir : dirs){
                    int a = p.a + dir[0];
                    int b = p.b +dir[1];

                    if( a >= 0 && a < grid.length && b >= 0 && b < grid[a].length && grid[a][b] == 1){
                        q.offer( new Pair(a, b) );
                        grid[a][b] = 2;
                        fresh--;
                    }
                }
            }
            ans++;
        }

        return fresh == 0 ? ans : -1;
    }
}