class Solution {
    int[] result;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses];

        result = new int[numCourses];
        index = numCourses - 1;

        for( int i = 0; i < numCourses; i++ ){
            if( hasCycle(i , adj, state ) ) return new int[0];
        }

        return result;
    }

    boolean hasCycle(int curr, List<List<Integer>> adj, int[] state){
        if(state[curr] == 1) return true;
        if(state[curr] == 2) return false;

        state[curr] = 1;

        for(int i : adj.get(curr)){
            if( hasCycle(i, adj, state)) return true;
        }

        result[index--] = curr;
        state[curr] = 2;
        return false;
    }
}