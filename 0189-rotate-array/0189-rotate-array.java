class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        int j = nums.length - (k % nums.length);

        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[j++ % nums.length];
        }

        for(int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }
    }
}