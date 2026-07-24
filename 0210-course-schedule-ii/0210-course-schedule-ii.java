class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] ans = new int[n];

        if(prerequisites.length == 0){
            for(int i = 0; i < n; i++){
                ans[ n-1 -i] = i;
            }
            return ans;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] i : prerequisites)adj.get(i[1]).add(i[0]);

        int[] in = new int[n];

        for(int i = 0; i < n; i++)
            for(int curr : adj.get(i))
                in[curr]++; 
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) q.offer(i);
        }

        int count = 0;

        while( !q.isEmpty() ){
            int top = q.poll();
            ans[count++] = top;

            for(int i : adj.get(top)){
                in[i]--;
                if(in[i] == 0) q.offer(i);
            }
        }

        if(count != n){
            return new int[]{};
        }

        return ans;
    }
}