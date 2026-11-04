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
        List<Integer>[] freqArr = new List[nums.length + 1];
        for (int val = -1000; val <= 1000; val++) {
            int count;
            if (val < 0) {
                count = map[val + 2001];
            } else {
                count = map[val];
            }
            if (freqArr[count] == null) {
                freqArr[count] = new ArrayList<>();
            }
            freqArr[count].add(val);
        }
        int[] kMost = new int[k];
        for (int index = nums.length; k > 0 && index >= 0; index--) {
            if (freqArr[index] != null && !freqArr[index].isEmpty()) {
                for (int listInd = 0; k > 0 && listInd < freqArr[index].size(); listInd++) {
                    kMost[--k] = freqArr[index].get(listInd);
                }
            }
        }
        return kMost;
    }
}
