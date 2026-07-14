class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int[] arr = new int[n+1];
        int ans = helper(n, arr);

        return ans;
    }

    int helper(int n, int[] arr){
        if(n <= 1) return n;
        if(arr[n] != 0) return arr[n];

        arr[n] = helper(n-1, arr) + helper(n-2, arr);
        return arr[n];
    }
}