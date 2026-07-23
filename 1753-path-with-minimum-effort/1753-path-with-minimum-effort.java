class Solution {
    class Pair{
        int i;
        int j;
        int height;
        Pair(int i, int j, int height){
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] minArr = new int[n][m];
        for(int[] i : minArr) Arrays.fill(i, Integer.MAX_VALUE);
        minArr[0][0] = 0;

        int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b)-> a.height - b.height );
        pq.add(new Pair(0, 0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.i == n-1 && curr.j == m-1) return curr.height;
            if (curr.height > minArr[curr.i][curr.j]) continue;
            
            for(int[] dir : dirs){
                int i = dir[0] + curr.i;
                int j = dir[1] + curr.j;
                if( i >= 0 && j >= 0 && i < n && j < m){
                    int diff = Math.abs(heights[curr.i][curr.j] - heights[i][j]);
                    diff = Math.max(diff, curr.height);
                    if(diff < minArr[i][j]){
                        minArr[i][j] = diff;
                        pq.offer(new Pair(i, j, diff) );
                    }
                }

            }
        }

        return 0;
    }
}