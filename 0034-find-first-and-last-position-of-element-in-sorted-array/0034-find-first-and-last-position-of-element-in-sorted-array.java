class Solution {
    int leftBinary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int index = -1;

        while( l <= r ){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target){
                if(mid == 0 || mid - 1 >= 0 && nums[mid - 1] != target) return mid;
                else r = mid-1;
            }

            else if(target > nums[mid]) l = mid+1;
            else r = mid-1;
        }

        return index;
    }

    int rightBinary(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int index = -1;

        while( l <= r ){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target){
                if(mid == nums.length - 1 || mid + 1 < nums.length && nums[mid + 1] != target) return mid;
                else l = mid+1;
            }

            else if(target > nums[mid]) l = mid+1;
            else r = mid-1;
        }

        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = leftBinary(nums, target);
        int right = rightBinary(nums, target);

        int[] arr = {left, right};
        return arr;
    }
}