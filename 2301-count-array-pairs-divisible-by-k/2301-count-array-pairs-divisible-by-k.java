class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long total = 0;
        for( int i = 0; i < nums.length; i++ ){
            int gcd1 = gcd(nums[i], k);

            for(int gcd2 : map.keySet()){
                if( ( (long)gcd1 * gcd2) % k == 0 ) total+= map.get(gcd2);
            }

            map.put(gcd1, map.getOrDefault(gcd1, 0) + 1);
        }

        return total;
    }

    int gcd(int a, int b){
        if(a < b){
            return gcd(b, a);
        }

        return b == 0 ? a : gcd(b, a % b); 
    }
}