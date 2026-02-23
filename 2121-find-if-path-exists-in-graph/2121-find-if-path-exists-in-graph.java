class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] i : edges){
            map.putIfAbsent(i[0], new ArrayList<>());
            map.putIfAbsent(i[1], new ArrayList<>());
            
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }

        HashSet<Integer> set = new HashSet<>();
        return dfs(source, destination, map, set);
    }

    boolean dfs(int curr, int d, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set){
        if( set.contains(curr) ) return false;
        set.add(curr);

        if( curr == d) return true;

        boolean ans = false;

        for( int i : map.get(curr) ){
            ans = ans | dfs(i, d, map, set);
            if(ans) return true;
        }

        return ans;
    }
}