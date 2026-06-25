class Solution {
    public int hIndex(int[] citations) {
        int ans = 0;

        for(int i = citations.length; i > 0; i--){
            int count = 0;
            for(int paper : citations){
                if(paper >= i) count++ ;
            }
            if(count >= i) return i;
        }

        return ans;
    }
}