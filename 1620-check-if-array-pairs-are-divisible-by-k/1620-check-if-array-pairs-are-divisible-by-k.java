class Solution {
    public boolean canArrange(int[] arr, int k) {
        int freq[] = new int[k];
        Arrays.fill(freq, 0);

        for(int i : arr){
            int rem = ((i % k) + k) % k;
            freq[rem]++;
        }

        for(int i = 0; i < k; i++){
            if(i == 0 || i * 2 == k){
                if( freq[i] % 2 != 0) return false;
            }else{
                if(freq[i] != freq[k-i])return false;
            }
        }

        return true;
    }
}