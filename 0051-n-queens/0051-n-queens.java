class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            ans.add(temp);
            return ans;
        }
        char[][] arr = new char[n][n];
        placer(arr, 0, n, ans, 0);

        return ans;
    }

    void placer(char[][] arr, int i, int n, List<List<String>> ans, int num){
        if(num == n){
            List<String> temp = new ArrayList<>();
            for(char[] row : arr){
                StringBuilder sb = new StringBuilder();
                for(char cell : row) {
                    sb.append(cell == '\u0000' ? '.' : cell);
                }
                temp.add(sb.toString());
            }
            ans.add( new ArrayList<>(temp) );
            return;
        }
        if(i < 0 || i >= n) return;

        for(int x = 0; x < n; x++){
            if( arr[i][x] == '\u0000' || !(arr[i][x] == '.') ){
                if( !helper(arr, i, x, n) ) continue;
                arr[i][x] = 'Q';
                placer(arr, i+1, n, ans, num+1);
                arr[i][x] = '\u0000';
            }
        }
    }

    boolean helper(char[][] arr, int i, int j, int n){
        for(int a = 0; a < n; a++){
            if(arr[i][a] == 'Q' || arr[a][j] == 'Q') return false;        }
        // for(int a = i+1, b = j+1; a < n && b < n; a++, b++){
        //     if(arr[a][b] == 'Q') return false;
        // }
        for(int a = i-1, b = j+1; a >= 0 && b < n; a--, b++){
            if(arr[a][b] == 'Q') return false;
        }
        // for(int a = i+1, b = j-1; a < n && b >= 0; a++, b--){
        //     if(arr[a][b] == 'Q') return false;
        // }
        for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
            if(arr[a][b] == 'Q') return false;
        }
        return true;
    }
}