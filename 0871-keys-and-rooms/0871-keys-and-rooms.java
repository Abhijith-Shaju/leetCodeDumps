class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int m = rooms.get(0).size();

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while( !q.isEmpty() ){
            int p = q.poll();
            visited[p] = true;

            for(int i : rooms.get(p)){
                if( !visited[i] )q.offer(i);
            }
        }

        for(boolean b : visited) if( !b ) return false;
        return true;
    }
}