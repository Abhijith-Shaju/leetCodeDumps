class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        while(num1 <= num2){
            int num = num1;

            if(num < 100) {
                num1++;
                continue;
            }
            int prev = num % 10;
            num /= 10;
            int curr = num % 10;
            num /= 10;

            while(num > 0){
                int temp = num%10;
                num /= 10;

                if(curr > prev && curr > temp) ans++;
                if(curr < prev && curr < temp) ans++;

                prev = curr;
                curr = temp;
            }
            num1++;
        }
        return ans;
    }
}