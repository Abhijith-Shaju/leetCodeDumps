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
        if(grid.length == 1 && grid[0].length == 1){
            if(grid[0][0] == 1) return -1;
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){ 
                    q.offer(new Pair(i, j));
                    grid[i][j] = 3;
                }
            }
        }

        if(q.size() == 0){
            boolean flag = false;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1) flag = true;
                }
            }
            if( !flag ) return 0;
        }

        if(q.size() == 0) return -1;
        int ans = 0;
        while( !q.isEmpty() ){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                if( p.a-1 >= 0 && grid[p.a - 1][p.b] == 1){ 
                    q.offer( new Pair(p.a-1, p.b) );
                    grid[p.a-1][p.b] = 2;
                }

                if( p.a+1 < grid.length && grid[p.a + 1][p.b] == 1) {
                    q.offer( new Pair(p.a+1, p.b) );
                    grid[p.a+1][p.b] = 2;
                }

                if( p.b-1 >= 0 && grid[p.a][p.b - 1] == 1) {
                    q.offer( new Pair(p.a, p.b-1) );
                    grid[p.a][p.b-1] = 2;
                }

                if( p.b+1 < grid[p.a].length && grid[p.a][p.b + 1] == 1) {
                    q.offer( new Pair(p.a, p.b+1) );
                    grid[p.a][p.b+1] = 2;
                }
            }
            ans++;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) return -1; 
            }
        }

        return ans-1;
    }
}