class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a) );
        
        q.addAll(map.keySet());

        int[] ans = new int[k];
        int i = 0;

        while( k-- > 0 ){
            ans[i++] = q.poll();
        }

        return ans;
    }
}