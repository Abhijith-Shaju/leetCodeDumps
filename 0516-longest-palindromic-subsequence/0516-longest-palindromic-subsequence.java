class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] will store the longest palindrome subseq for substring s[i...j]
        Integer[][] memo = new Integer[n][n];
        return helper(s, 0, n - 1, memo);
    }

    private int helper(String s, int i, int j, Integer[][] memo) {
        // Base cases
        if (i == j) return 1;
        if (i > j) return 0;

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + helper(s, i + 1, j - 1, memo);
        } else {
            int x = helper(s, i + 1, j, memo);
            int y = helper(s, i, j - 1, memo);
            memo[i][j] = Math.max(x, y);
        }

        return memo[i][j];
    }
}