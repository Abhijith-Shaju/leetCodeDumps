class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O') sink(i, 0, board);
            if(board[i][m-1] == 'O') sink(i, m-1, board);
        }
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O') sink(0, i, board);
            if(board[n-1][i] == 'O') sink(n-1, i, board);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }

    }

    void sink(int i, int j, char[][] arr){
        if( i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || arr[i][j] == 'X' || arr[i][j] == 'T') return;

        arr[i][j] = 'T';
        sink(i+1, j, arr);
        sink(i-1, j, arr);
        sink(i, j+1, arr);
        sink(i, j-1, arr);

    }
}