class Solution {
    class Pair{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        double[] arr = new double[n];

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> Double.compare(b.prob, a.prob) );
        pq.offer(new Pair(start_node, 1));

        while( !pq.isEmpty() ){
            Pair p = pq.poll();

            if(p.node == end_node) return p.prob;
            
            if(p.prob < arr[p.node]) continue;
            
            for(Pair pair : adj.get(p.node) ){
                double probs = p.prob * pair.prob;
                if(probs > arr[pair.node]){
                    arr[pair.node] = probs;
                    pq.offer(new Pair(pair.node, probs));
                }
            }
        }
        return 0;
    }
}