class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] map = new int[2002];
        for (int val : nums) {
            if (val < 0) {
                map[val + 2001]++;
            } else {
                map[val]++;
            }
        }
        Map<Integer, Set<Integer>> freq = new TreeMap<>(Comparator.reverseOrder());
        for (int val : nums) {
            int key;
            if (val < 0) {
                key = map[val + 2001];
            } else {
                key = map[val];
            }
            Set<Integer> arr = freq.getOrDefault(key, new HashSet<>());
            arr.add(val);
            freq.putIfAbsent(key, arr);
        }
        int[] kMost = new int[k];
        for (Set<Integer> arr : freq.values()) {
            for (int val : arr) {
                kMost[--k] = val;
                if (k == 0) {
                    break;
                }
            }
            if (k == 0) {
                break;
            }
        }
        
        return kMost;
    }
}
