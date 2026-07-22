class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while( !q.isEmpty() ){
            int p = q.poll();

            for(int i : rooms.get(p)){
                if( !visited[i] ){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        for(boolean b : visited) if( !b ) return false;
        return true;
    }
}