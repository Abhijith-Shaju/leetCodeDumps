class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;

        return 1 + helper("A", "A", n);
    }

    int helper(String s, String copy, int n){
        if(s.length() == n) return 0;
        if(s.length() > n) return 10000;

        int x = 1 + helper(s+copy, copy, n);
        copy = s;
        int y = 2 + helper(s+copy, copy, n);

        return Math.min(x, y);
    }
}