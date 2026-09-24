class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();

        int i = 0, j = arr.length-1;

        while( i < j ){
            if( arr[i] != arr[j] ){
                char c = arr[i] > arr[j] ? arr[j] : arr[i];
                arr[i] = arr[j] = c;
            }
            i++;
            j--;
        }

        return String.valueOf(arr);
    }
}