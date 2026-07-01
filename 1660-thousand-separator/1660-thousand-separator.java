class Solution {
    public String thousandSeparator(int n) {
        StringBuilder ans = new StringBuilder(Integer.toString(n));

        if(ans.length() <= 3) return ans.toString();
        for(int i = ans.length()- 1, count= 1; i > 0; i--, count++){
            if(count % 3 == 0) ans.insert(i, ".");
        }
        return ans.toString();
    }
}