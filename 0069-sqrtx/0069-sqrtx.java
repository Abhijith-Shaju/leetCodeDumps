class Solution {
    public int mySqrt(int x) {
        if(x == 1 || x == 0) return x;
        int ans = 1;

        for(long i = 2; i <= x/2; i++){
            if( i * i > x ) break;
            if( i*i <= x )ans = (int)i;
        }

        return ans;
    }
}