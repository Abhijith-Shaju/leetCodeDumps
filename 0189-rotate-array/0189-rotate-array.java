class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return;

        oN(nums, k);
    }

    public void oN(int[] nums, int k){
        int n = nums.length;

        int[] arr = new int[n];
        int j = n - (k % n);

        for(int i = 0; i < n; i++){
            arr[i] = nums[j++ % n];
        }

        for(int i = 0; i < n; i++){
            nums[i] = arr[i];
        }
    }
}