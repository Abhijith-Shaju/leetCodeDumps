class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int sum = 0;
            nums[queries[i][1]] += queries[i][0];

            for(int num : nums) if( num % 2 == 0) sum += num;

            ans[i] = sum;
        }

        return ans;
    }
}