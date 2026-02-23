class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int ans = nums[l];

        while(l <= r){
            int mid = (r+l)/2;
            if( mid+1 <= r && nums[mid+1] < nums[mid]) return nums[mid+1];

            ans = Math.min(ans, nums[mid]);

            while(nums[l] == nums[r] && l < r){
                l++;
                r--;
            }

            if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid-1;
            }

        }
        return ans;
    }
}