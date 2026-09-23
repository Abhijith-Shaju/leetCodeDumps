class Solution {
    public int countElements(int[] nums) {
        // Arrays.sort(nums);
        // int i;
        // int j;

        // for(i = 0; i < nums.length; i++)if(nums[i] != nums[0]) break;
        // for(j = nums.length-1; j >= 0; j--)if(nums[j] != nums[nums.length-1]) break;

        // if( i < j ) return j - i + 1;
        // return i==j ? 1 : 0; 

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int minC = 0, maxC = 0;
        for(int i : nums){
            if(i == min) minC++;
            if(i == max) maxC++;
        }

        if(minC + maxC >= nums.length) return 0;

        return nums.length - ( minC + maxC ); 
    }
}