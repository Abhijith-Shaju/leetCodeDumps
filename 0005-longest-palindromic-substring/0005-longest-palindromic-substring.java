class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length()-1; i++){
            int l = i, r = i;

            while( l >= 0 && r < s.length() ){
                if(s.charAt(l) != s.charAt(r))break;
                else if( r - l + 1 > right - left + 1){
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while( l >= 0 && r < s.length() ){
                if(s.charAt(l) != s.charAt(r))break;
                else if( r - l + 1 >  right - left + 1){
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
            
        }

        return s.substring(left, right + 1);
    }
}