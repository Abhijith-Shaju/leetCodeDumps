class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if( r * c != mat.length * mat[0].length ) return mat;
        int[] arr = new int[r * c];
        int index = 0;
        for(int[] i : mat){
            for(int j : i){
                arr[index++] = j;
            }
        }

        int[][] ans = new int[r][c];
        index=0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                ans[i][j] = arr[index++];
            }
        }

        return ans;
    }
}