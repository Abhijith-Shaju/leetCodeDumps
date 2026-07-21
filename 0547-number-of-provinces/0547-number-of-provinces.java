class Solution {
    public int findCircleNum(int[][] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 1){
                    map.putIfAbsent(i, new ArrayList<>() );
                    map.get(i).add(j);
                }
            }
        }

        int ans = 0;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        while( !map.isEmpty() ){
            q.offer(map.keySet().iterator().next());
            set.add(q.peek());
            
            while( !q.isEmpty() ){
                int temp = q.poll();
                for( int i : map.get(temp) ){
                    if( !set.contains(i) ){
                        q.offer(i);
                        set.add(i);
                    }
                }
                map.remove(temp);
            }
            ans++;
        }

        return ans;
    }
}