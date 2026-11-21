class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int prefix = nums[0];
        for (int index = 1; index < nums.length; index++) {
            ans[index] = prefix;
            prefix *= nums[index];
        }
        int suffix = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            ans[index] = suffix * ans[index];
            suffix *= nums[index];
        }
        return ans;
    }
}  
