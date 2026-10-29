class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int maxSeq = 0;
        for (int index = 0; index < nums.length; index++) {
            incSubseq(nums, dp, index);
            maxSeq = Math.max(dp[index], maxSeq);
        }
        return maxSeq + 1;
    }

    int incSubseq(int[] nums, int[] dp, int prev) {
        if (prev == nums.length) {
            return 0;
        }
        if (dp[prev] != -1) {
            return dp[prev];
        }
        int maxSeq = 0;
        for (int index = prev + 1; index < nums.length; index++) {
            if (nums[index] > nums[prev]) {
                maxSeq = Math.max(maxSeq, 1 + incSubseq(nums, dp, index));
            }
        }
        return dp[prev] = maxSeq;
    }
}