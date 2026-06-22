class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return;

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