class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        // int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for( int i = n-1; i >= 0; i-- ){

            while(!stack.isEmpty() && prices[i] < stack.peek()) stack.pop();

            int temp = prices[i];

            if( !stack.isEmpty() )
                prices[i] = prices[i] - stack.peek();

            stack.push(temp);

        }

        return prices;
    }
}