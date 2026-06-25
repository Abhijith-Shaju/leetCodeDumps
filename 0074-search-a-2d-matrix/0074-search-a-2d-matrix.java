class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int len = matrix[i].length - 1;
            if(target >= matrix[i][0] && target <= matrix[i][len]) return binarySearch(matrix[i], target);
        }

        return false;
    }

    boolean binarySearch(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = l + ( r - l ) / 2;

            if(arr[mid] == target) return true;

            if(target > arr[mid]) l = mid+1;
            else r = mid-1;
        }

        return false;
    }
}