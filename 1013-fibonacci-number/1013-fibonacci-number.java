class Solution {
    public int fib(int n) {
        if(n <= 1)return n;
        
        int one = 0;
        int two = 1;

        for(int i = 1; i < n; i++){
            int temp = two;
            two = two + one;
            one = temp;
        }

        return two;
    }
}