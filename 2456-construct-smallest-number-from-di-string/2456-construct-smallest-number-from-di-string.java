class Solution {
    public String smallestNumber(String pattern) {
        Deque<Integer> stack = new ArrayDeque<>();
        String ans = "";
        
        for(int i = 0; i <= pattern.length(); i++){
            stack.push(i+1); 

            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while( !stack.isEmpty() ) {
                    ans += Integer.toString(stack.peek());
                    stack.pop();
                }
            }
        }
        return ans;
    }
}