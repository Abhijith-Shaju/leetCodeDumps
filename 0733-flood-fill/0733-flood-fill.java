class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if( image[sr][sc] != color ) helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    void helper(int[][] arr, int r, int c, int color, int prev){
        if( r >= arr.length || r < 0 || c >= arr[r].length || c < 0 || arr[r][c] != prev ) return;

        arr[r][c] = color;

        helper(arr, r+1, c, color, prev);
        helper(arr, r-1, c, color, prev);
        helper(arr, r, c+1, color, prev);
        helper(arr, r, c-1, color, prev);
    }
}