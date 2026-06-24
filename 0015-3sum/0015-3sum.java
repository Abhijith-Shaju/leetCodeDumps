class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int l = i+1, r = nums.length-1;

            while(l < r){
                if( nums[i] + nums[l] + nums[r] == 0 ){
                    
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    l++;
                    r--;


                    if(!set.contains(temp)){
                        arr.add(temp);
                        set.add(temp);
                    }
                    continue;
                }

                if(nums[i] + nums[l] + nums[r] < 0) l++;
                else r--;
            }
        }

        return arr;
    }
}