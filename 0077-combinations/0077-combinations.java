class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        helper(n, k, 1, temp, ans);

        return ans;
    }

    void helper(int n, int k, int start, List<Integer> temp, List<List<Integer>> ans){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp) );
            return;
        }

        for(int i = start; i <= n; i++){
            if( !temp.contains(i)){
                temp.add(i);
                helper(n, k, i+1, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}