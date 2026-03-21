class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0, j;

        double avg = 0.0;
        int ans = 0;

        for(j = 0; j < k; j++) avg += arr[j];
        
        if( avg / k >= (double)threshold ) ans++;


        while( j < arr.length ){

            // System.out.print(avg + " :  ");
            // System.out.printf("%.2f" , avg / k);
            // System.out.println();


            
            avg -= arr[i++];
            avg += arr[j++];

            if( avg / k >= (double)threshold ) ans++;
        }

        return ans;
    }
}