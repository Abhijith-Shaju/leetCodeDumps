class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();


        helper(nums, new ArrayList<>(), ans);

        return ans;

    }

    void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp) );
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if( !temp.contains(nums[i])){
                temp.add(nums[i]);
                helper(nums, temp, ans);
                temp.remove(temp.size()-1);
            }  
        }
    }
}