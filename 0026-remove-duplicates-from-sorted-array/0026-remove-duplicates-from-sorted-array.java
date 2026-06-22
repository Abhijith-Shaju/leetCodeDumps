class Solution {
    public int removeDuplicates(int[] nums) {
        // if(nums.length == 1) return 1;
        
        int i = 0, j = 0;
        int k = 1;
        
        while( j < nums.length ){
            while( j < nums.length && nums[i] == nums[j] ) j++;
            
            i = j;

            if(j < nums.length) nums[k++] = nums[j++];
        }

        return k;
    }
}