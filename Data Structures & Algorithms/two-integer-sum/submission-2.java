class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prefixHash = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int getVal = target - nums[index];
            int valIdx = prefixHash.getOrDefault(getVal, -1);
            if (valIdx != -1) {
                return new int[] { valIdx, index };
            }
            prefixHash.put(nums[index], index);
        }
        return new int[] { -1, -1 };
    }
}
