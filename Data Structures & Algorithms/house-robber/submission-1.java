class Solution {
    public int rob(int[] nums) {
        if (nums.length < 3) {
            int max = -1;
            for (int cost : nums) max = Math.max(cost, max);
            return max;
        }
        nums[2] += nums[0];
        for (int index = 3; index < nums.length; index++) {
            nums[index] += Math.max(nums[index - 2], nums[index - 3]);
        }
        return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    }
}
