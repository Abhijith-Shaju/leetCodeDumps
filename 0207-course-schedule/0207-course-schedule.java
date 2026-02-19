class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();    
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if( hasCycle(i, adj, state) ){
                return false;
            }
        }

        return true;
    }

    boolean hasCycle(int curr, List<List<Integer>> adj, int[] state){
        if(state[curr] == 1) return true;
        if(state[curr] == 2) return false;

        //visitinf it now so it is set as 1;
        state[curr] = 1;

        for(int next : adj.get(curr)){
            if( hasCycle(next, adj, state) ){
                return true;
            }
        }

        //finished visting;
        state[curr] = 2;
        return false;
    }
}