class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        int max1 = 0, max2 = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            if (index > 2) {
                nums[index] += Math.max(nums[index - 2], nums[index - 3]);
            } else if (index == 2) {
                nums[index] += nums[index - 2];
            }
            max1 = Math.max(max1, nums[index]);
        }
        for (int index = 1; index < nums.length; index++) {
            if (index > 3) {
                nums2[index] += Math.max(nums2[index - 2], nums2[index - 3]);
            } else if (index == 3) {
                nums2[index] += nums2[index - 2];
            }
            max2 = Math.max(max2, nums2[index]);
        }
        return Math.max(max1, max2);
    }
}
