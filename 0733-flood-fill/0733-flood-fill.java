class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            helper(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    void helper(int[][] img, int r, int c, int color, int prev){
        if(r >= img.length || r < 0 || c >= img[r].length || c < 0 || img[r][c] != prev){
            return;
        }
        int pre = img[r][c];
        img[r][c] = color;

        helper(img, r + 1, c, color, pre);
        helper(img, r - 1, c, color, pre);
        helper(img, r, c + 1, color, pre);
        helper(img, r, c - 1, color, pre);
    }
}