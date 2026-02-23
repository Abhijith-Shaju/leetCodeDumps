class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;
        int l = 0, r = nums.length-1;

        while( l <= r ){
            int mid = (r + l) / 2;

            if(nums[mid] == target || nums[l] == target || nums[r] == target) return true;

            while( nums[l] == nums[r] && l < r){                
                l++;
                r--;
            }
            if(nums[l] == target || nums[r] == target) return true;


            if(nums[l] <= nums[mid]){
                if(nums[mid] >= target && nums[l] <= target){
                    r = mid-1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}