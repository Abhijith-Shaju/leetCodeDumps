class Solution {
    public int compress(char[] chars) {
        int curr = 0;
        int i = 0;

        while( i < chars.length ){
            chars[curr++] = chars[i++];
            int num = 1;
            while(i < chars.length && chars[i-1] == chars[i] ){
                num++;
                i++;
            }

            if(num > 1){
                char[] arr = String.valueOf(num).toCharArray();
                for(char x : arr) chars[curr++] = x;
            }
        }
        return curr;
    }
}