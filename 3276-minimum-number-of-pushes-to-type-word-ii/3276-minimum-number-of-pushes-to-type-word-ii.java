class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray()) freq[c - 'a']++;

        int ans = 0;
        Arrays.sort(freq);

        for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) break;
            int loop = ((25 - i) / 8) + 1;
            ans += loop * freq[i];
        }

        return ans;
    }
}