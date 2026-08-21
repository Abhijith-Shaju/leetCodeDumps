class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();

        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int num = n*m;
        int i = 0, j = 0, index = 0;

        while(num > 0){
            while( i < n && j < m && i >= 0 && j >= 0 && matrix[i][j] != 999){
                ans.add(matrix[i][j]);
                matrix[i][j] = 999;
                i += dirs[index][0];
                j += dirs[index][1];
                num--;
            }
            i -= dirs[index][0];
            j -= dirs[index][1];

            index = (index + 1) % 4;

            i += dirs[index][0];
            j += dirs[index][1];
        }

        return ans;
    }
}