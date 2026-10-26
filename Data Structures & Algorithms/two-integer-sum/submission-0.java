class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {
            for (int innerIndex = index + 1; innerIndex < nums.length; innerIndex++) {
                if (nums[index] + nums[innerIndex] == target) {
                    return new int[] { index, innerIndex };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
