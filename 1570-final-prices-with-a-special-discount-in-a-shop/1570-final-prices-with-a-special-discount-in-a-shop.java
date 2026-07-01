class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for( int i = n-1; i >= 0; i-- ){

            while(!stack.isEmpty() && prices[i] < stack.peek()) stack.pop();

            if(stack.isEmpty()) ans[i]= prices[i];
            else ans[i] = prices[i] - stack.peek();

            stack.push(prices[i]);
        }

        return ans;
    }
}