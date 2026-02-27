class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        helper(n, arr);

        return arr[n];
    }

    int helper(int n, int[] arr){
        if(n == 0){
            arr[0] = 1;
            return 1;
        }
        if(n == 1){
            arr[1] = 1;
            return 1;
        }

        if(arr[n] == 0){
            arr[n] = helper(n-1, arr) + helper(n-2, arr);
        }

        return arr[n];
    }
}