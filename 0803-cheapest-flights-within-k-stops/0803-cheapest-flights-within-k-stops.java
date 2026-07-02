class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, src, 0});

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];

            if (stops > k) continue;

            for (int[] next : adj[node]) {
                int nextNode = next[0];
                int price = next[1];
                int nextCost = cost + price;

                if (nextCost < minCost[nextNode]) {
                    minCost[nextNode] = nextCost;
                    q.offer(new int[] {stops + 1, nextNode, nextCost});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}