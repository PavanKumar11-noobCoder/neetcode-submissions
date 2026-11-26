class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum == target) {
                return new int[] {left + 1, right + 1};
            } else if (currSum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }

    // t = 3 -> 1 2
    // t = 7 -> 3 4
}
