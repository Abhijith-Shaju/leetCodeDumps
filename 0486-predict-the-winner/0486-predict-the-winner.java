class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[] scores = new int[]{0, 0};
        return helper(nums, 0, nums.length-1, scores, 0);
    }

    boolean helper(int[]nums, int i, int j, int[] scores, int player){
        if( j == i ) {
            scores[player] += nums[i];
            boolean win = scores[0] >= scores[1];
            scores[player] -= nums[i];
            return win;
        }

        scores[player] += nums[i];
        boolean left = helper(nums, i+1, j, scores, (player+1) % 2 );
        scores[player] -= nums[i];

        scores[player] += nums[j];
        boolean right = helper(nums, i, j-1, scores, (player+1) % 2 );
        scores[player] -= nums[j];

        return player == 0 ? left || right : left && right;
    }
}