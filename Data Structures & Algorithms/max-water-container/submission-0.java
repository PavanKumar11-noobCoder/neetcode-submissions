class Solution {
    public int maxArea(int[] heights) {
        int maximum = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maximum = Math.max(maximum, minHeight * (right - left));
            if (heights[left] == heights[right]) {
                left++;
                right--;
            } else if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximum;
    }
}
