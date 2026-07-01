class Solution {
    public String smallestNumber(String pattern) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder("");

        for(int i = 0; i <= pattern.length(); i++){
            stack.push(i+1); 

            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while( !stack.isEmpty() ) {
                    ans.append( Integer.toString(stack.peek()) );
                    stack.pop();
                }
            }
        }
        return ans.toString();
    }
}