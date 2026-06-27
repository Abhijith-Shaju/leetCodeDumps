class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] temp = new int[mat.length];

        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1) count++;
            }

            temp[i] = count;
        }

        int max = 0;

        for(int i = 0; i < temp.length; i++){
            if( temp[i] > temp[max]) max = i;
        }

        return new int[]{max, temp[max]};
    }
}