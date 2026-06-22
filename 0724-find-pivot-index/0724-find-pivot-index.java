class Solution {
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            pre[i+1] = pre[i] + nums[i];
        }

        for(int i = 1; i < pre.length; i++){
            if( pre[i-1] == ( pre[pre.length-1] - pre[i] ) ) return i-1;
        }

        return -1;
    }
}