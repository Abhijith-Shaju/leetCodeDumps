class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        if(k == 0 || k == n) return;

        int d = n - k;
        int i = d;
        int j = n - d;

        while( i != j ){
            if( i < j ){
                swap(nums, d - i, j + d - i, i);
                j -= i;
            }else{
                swap(nums, d - i, d, j);
                i -= j;
            }
        }

        swap(nums, d-i, d, i);
    }

    void swap(int[] nums, int fi, int si, int len){
        for(int i = 0; i < len; i++){
            int temp = nums[fi + i];
            nums[fi + i] = nums[si + i];
            nums[si + i] = temp;
        }
    }
}