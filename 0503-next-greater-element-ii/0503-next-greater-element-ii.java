class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        for(int i = (n * 2) - 1; i >= 0; i-- ){

            while( !stack.isEmpty() && nums[i % n] >= stack.peek()) 
                stack.pop();

            if( !stack.isEmpty() )
                ans[i % n] = stack.peek();

            stack.push(nums[i % n]);
        }

        return ans;
    }
}