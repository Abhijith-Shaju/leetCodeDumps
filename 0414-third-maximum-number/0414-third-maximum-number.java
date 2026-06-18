class Solution {
    public int thirdMax(int[] nums) {
        // Arrays.sort(nums);

        // int curr = nums[nums.length-1];
        // int count = 1;

        // for(int i = nums.length-2; i >=0; i--){
        //     if(nums[i] == curr)continue;
        //     curr = nums[i];
        //     count++;
        //     if(count == 3)break;
        // }

        // return (count == 3) ? curr : nums[nums.length-1];


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> set = new HashSet<Integer>();

        for(int i : nums){
            set.add(i);
        }
        for(int i : set){
           maxHeap.offer(i);
        }

        if(maxHeap.size() < 3){
            return maxHeap.peek();
        }

        maxHeap.poll();
        maxHeap.poll();

        return maxHeap.peek();
    }
}