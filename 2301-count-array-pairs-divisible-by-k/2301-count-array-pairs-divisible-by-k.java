class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> gcdFreq = new HashMap<>();
        long total = 0;

        // 1. Group numbers by their GCD with k
        for (int num : nums) {
            int g = gcd(num, k);
            gcdFreq.put(g, gcdFreq.getOrDefault(g, 0) + 1);
        }

        // 2. Compare pairs of GCDs
        List<Integer> keys = new ArrayList<>(gcdFreq.keySet());
        for (int i = 0; i < keys.size(); i++) {
            int g1 = keys.get(i);
            long count1 = gcdFreq.get(g1);

            for (int j = i; j < keys.size(); j++) {
                int g2 = keys.get(j);
                long count2 = gcdFreq.get(g2);

                if ((long) g1 * g2 % k == 0) {
                    if (i == j) {
                        // Same GCD group: use nC2
                        total += (count1 * (count1 - 1)) / 2;
                    } else {
                        // Different GCD groups: multiply counts
                        total += count1 * count2;
                    }
                }
            }
        }

        return total;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}