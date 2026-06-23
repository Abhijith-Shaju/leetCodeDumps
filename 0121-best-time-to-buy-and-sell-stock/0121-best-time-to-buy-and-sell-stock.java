class Solution {
    public int maxProfit(int[] arr) {
        int max = 0;

        int l = 0, r = 1; 

        while( r < arr.length ){
            if(arr[l] < arr[r]) max = Math.max(max, arr[r] - arr[l]);
            else l = r;
            
            r++;
        }
        return max;

    }
}