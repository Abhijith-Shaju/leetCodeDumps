class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int i;
        int j;

        for(i = 0; i < nums.length; i++)if(nums[i] != nums[0]) break;
        for(j = nums.length-1; j >= 0; j--)if(nums[j] != nums[nums.length-1]) break;

        if( i < j ) return j - i + 1;
        return i==j ? 1 : 0; 
    }
}