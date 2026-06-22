class Solution {
    public int maxSubArray(int[] nums) {
        //Kadage's Algorithm

        int max = Integer.MIN_VALUE;

        int i = 0;
        int sum = 0;
        while( i < nums.length ){
            sum += nums[i++];

            max = Math.max(max, sum);

            sum = sum < 0 ? 0 : sum;
        }

        return max;
    }
}