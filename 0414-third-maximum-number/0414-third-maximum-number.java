class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int curr = nums[nums.length-1];
        int count = 1;

        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] == curr)continue;
            curr = nums[i];
            count++;
            if(count == 3)break;
        }

        return (count == 3) ? curr : nums[nums.length-1];
    }
}