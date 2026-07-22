class Solution {
    class Pair{
        int a, b, d;
        Pair(int a, int b, int d){
            this.a = a;
            this.b = b;
            this.d = d;
        } 
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 0) q.offer(new Pair(i, j, 0));
            }
        }
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while( !q.isEmpty() ){
            int size = q.size();
            Pair p = q.poll();
            for(int[] dir : dirs){
                int a = p.a+dir[0];
                int b = p.b+dir[1];
                if(a >= 0 && b >=0 && a < mat.length && b < mat[a].length && mat[a][b] == 1){
                    ans[a][b] = p.d+1;
                    q.offer( new Pair(a, b, p.d+1) );
                    mat[a][b] = 0;
                }
            }
        }
        return ans;
    }
}