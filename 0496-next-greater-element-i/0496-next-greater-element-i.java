class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] temp = new int[nums2.length];

        for( int i = nums2.length-1; i >= 0; i-- ){
            map.put(nums2[i], i);

            while( !stack.isEmpty() && nums2[i] >= stack.peek() ) stack.pop();

            if( stack.isEmpty() ) temp[i] = -1;
            else temp[i] = stack.peek();

            stack.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            ans[i] = temp[map.get(nums1[i])];
        }

        return ans;
    }
}