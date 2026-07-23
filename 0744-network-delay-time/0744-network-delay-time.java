class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        int[] ansArr = new int[n+1];
        Arrays.fill(ansArr, Integer.MAX_VALUE);
        ansArr[k] = 0;

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new Pair(v, t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b)-> a.dist - b.dist );
        pq.offer(new Pair(k, 0));

        while( !pq.isEmpty() ){
            Pair curr = pq.poll();
            if(curr.dist > ansArr[curr.node]) continue;

            for(Pair p : adj.get(curr.node)){
                int currDist = curr.dist + p.dist;

                if(currDist < ansArr[p.node]){
                    ansArr[p.node] = currDist;
                    pq.offer(new Pair(p.node, currDist) );
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < ansArr.length; i++) {
            if(ansArr[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, ansArr[i]);
        }

        return ans;
    }
}