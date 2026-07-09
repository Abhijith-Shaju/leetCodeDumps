class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        
        int temp = Integer.MIN_VALUE;

        for(int i = nums.length - 1 ; i >= 0; i--){

            if( nums[i] < temp ) return true;
            
            while( !stack.isEmpty() && stack.peek() < nums[i]){
                temp = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}