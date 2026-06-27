class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[][] temp = new int[mat.length][2];

        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) count++;
            }

            temp[i][0] = 1;
            temp[i][1] = count;
        }

        int max = 0;

        for(int i = 0; i < temp.length; i++){
            if( temp[i][1] > temp[max][1]) max = i;
        }

        return new int[]{max, temp[max][1]};
    }
}