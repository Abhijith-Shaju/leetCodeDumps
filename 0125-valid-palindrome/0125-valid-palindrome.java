class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();

        for(char c : s.toCharArray() ){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }

        System.out.println(sb);
        
        for(int i = 0; i < sb.length() / 2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }

        return true;
    }
}