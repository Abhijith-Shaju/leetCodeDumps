class Solution {
    public int minimumChairs(String s) {
        int ans = 0;
        int empty = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'E'){
                if(empty == 0){
                    ans++;
                    empty++;
                }
                empty--;
            }else{
                empty++;
            }
        }

        return ans;
    }
}