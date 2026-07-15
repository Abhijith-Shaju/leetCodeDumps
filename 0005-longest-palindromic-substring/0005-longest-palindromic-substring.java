class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String ans = "";

        for(int i = 0; i < s.length()-1; i++){
            int l = i, r = i;

            while( l >= 0 && r < s.length() ){
                if(s.charAt(l) != s.charAt(r))break;
                else if( r - l + 1 > ans.length()) ans = s.substring(l, r+1);
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while( l >= 0 && r < s.length() ){
                if(s.charAt(l) != s.charAt(r))break;
                else if( r - l + 1 > ans.length()) ans = s.substring(l, r+1);
                l--;
                r++;
            }
            
        }

        return ans;
    }
}