class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] a = new int[map.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            a[index++] = entry.getValue();
        }

        Arrays.sort(a);

        int sum = 0;
        int ans = 0;
        for(int i = a.length - 1; i >= 0; i--){
            sum += a[i];
            ans++;
            if(sum >= (arr.length / 2) ) break;
        }

        return ans;

    }
}