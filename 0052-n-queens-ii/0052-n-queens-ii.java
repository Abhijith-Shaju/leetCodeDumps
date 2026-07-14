class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[]{0};
        if(n == 1){
            return 1;
        }
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(arr[i], '.');
        }
        placer(arr, 0, n, ans, 0);

        return ans[0];
    }

    void placer(char[][] arr, int i, int n, int[] ans, int num){
        if(num == n){
            ans[0] += 1;
        }
        if(i < 0 || i >= n) return;

        for(int x = 0; x < n; x++){
            if( !helper(arr, i, x, n) ) continue;
            arr[i][x] = 'Q';
            placer(arr, i+1, n, ans, num+1);
            arr[i][x] = '.';
        }
    }

    boolean helper(char[][] arr, int i, int j, int n){
        for(int a = 0; a < i; a++){
            if(arr[a][j] == 'Q') return false;
            }
        for(int a = i-1, b = j+1; a >= 0 && b < n; a--, b++){
            if(arr[a][b] == 'Q') return false;
        }
        for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
            if(arr[a][b] == 'Q') return false;
        }
        return true;
    }
}