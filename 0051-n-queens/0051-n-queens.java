class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            ans.add(temp);
            return ans;
        }
        for(int i = 0; i < n; i++){
            String[][] arr = new String[n][n];
            int num = helper(arr, 0, i, n);
            arr[0][i] = "Q";
            
            placer(arr, 1, i, n, ans, num);
            
        }
        return ans;
    }

    void placer(String[][] arr, int i, int j, int n, List<List<String>> ans, int num){
        if(num == n){
            List<String> temp = new ArrayList<>();
            for(String[] s : arr){
                temp.add(String.join("", s));
            }
            System.out.println(temp);
            ans.add( new ArrayList<>(temp) );
            return;
        }
        if(i < 0 || j < 0 || i >= n || j >= n) return;

        String[][] copy = new String[arr.length][];
        for (int x = 0; x < arr.length; x++) {
            copy[x] = arr[x].clone(); 
        }

        for(int x = 0; x < n; x++){
            if( arr[i][x] == null || !arr[i][x].equals(".") ){
                helper(arr, i, x, n);
                arr[i][x] = "Q";
                placer(arr, i+1, j, n, ans, num+1);

                for (int k = 0; k < arr.length; k++) {
                    arr[k] = copy[k].clone(); 
                }
            }
        }


    }

    int helper(String[][] arr, int i, int j, int n){
        for(int a = 0; a < n; a++){
            if(arr[i][a] == "Q" || arr[a][j] == "Q")continue;
            arr[i][a] = ".";
            arr[a][j] = ".";
        }
        for(int a = i+1, b = j+1; a < n && b < n; a++, b++){
            if(arr[a][b] == "Q")continue;

            arr[a][b] = ".";
        }
        for(int a = i-1, b = j+1; a >= 0 && b < n; a--, b++){
            if(arr[a][b] == "Q")continue;

            arr[a][b] = ".";
        }
        for(int a = i+1, b = j-1; a < n && b >= 0; a++, b--){
            if(arr[a][b] == "Q")continue;

            arr[a][b] = ".";
        }
        for(int a = i-1, b = j-1; a >= 0 && b >= 0; a--, b--){
            if(arr[a][b] == "Q")continue;

            arr[a][b] = ".";
        }

        return 1;
    }
}