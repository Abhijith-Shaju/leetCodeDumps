class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            ans.add(temp);
            return ans;
        }
        String[][] arr = new String[n][n];
        placer(arr, 0, n, ans, 0);

        return ans;
    }

    void placer(String[][] arr, int i, int n, List<List<String>> ans, int num){
        if(num == n){
            List<String> temp = new ArrayList<>();
            for(String[] row : arr){
                StringBuilder sb = new StringBuilder();
                for(String cell : row) {
                    sb.append(cell == null ? "." : cell);
                }
                temp.add(sb.toString());
            }
            ans.add( new ArrayList<>(temp) );
            return;
        }
        if(i < 0 || i >= n) return;

        for(int x = 0; x < n; x++){
            if( !helper(arr, i, x, n) ) continue;
            arr[i][x] = "Q";
            placer(arr, i+1, n, ans, num+1);
            arr[i][x] = null;
        }
    }

    boolean helper(String[][] arr, int i, int j, int n){
        for(int a = 0; a < n; a++){
            if( "Q".equals(arr[i][a]) || "Q".equals(arr[a][j]) ) return false;        }
        for(int a = i+1, b = j+1; a < n && b < n; a++, b++){
            if( "Q".equals(arr[a][b]) ) return false;
        }
        for(int a = i-1, b = j+1; a >= 0 && b < n; a--, b++){
            if( "Q".equals(arr[a][b]) ) return false;
        }
        for(int a = i+1, b = j-1; a < n && b >= 0; a++, b--){
            if( "Q".equals(arr[a][b]) ) return false;
        }
        for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
            if( "Q".equals(arr[a][b]) ) return false;
        }
        return true;
    }
}