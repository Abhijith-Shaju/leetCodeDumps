class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] sub = s.toCharArray();
        
        helper(ans, sub, 0);

        return ans;
    }

    void helper(List<String> ans, char[] arr, int i){
        if(i == arr.length){
            ans.add(new String(arr));
            return;
        }

        if( Character.isLetter(arr[i]) ){
            arr[i] = Character.toLowerCase(arr[i]);
            helper(ans, arr, i+1);

            arr[i] = Character.toUpperCase(arr[i]);
            helper(ans, arr, i+1);
        }else{
            helper(ans, arr, i+1);
        }
    }
}