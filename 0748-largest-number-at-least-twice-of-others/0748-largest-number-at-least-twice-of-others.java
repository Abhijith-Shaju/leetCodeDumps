class Solution {
    public int dominantIndex(int[] nums) {

        int x = 0, y = -1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= nums[x]){
                y = x;
                x = i;
            }
            else if(y == -1 || nums[i] > nums[y]){
                y=i;
            }
        }

        if(nums[x] >= nums[y]*2) return x;

        return -1;
    }
}