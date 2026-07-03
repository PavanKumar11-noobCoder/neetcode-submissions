class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[512];
        Arrays.fill(index, -1);
        int maxsub = 0, length = s.length();
        for (int left=0, right = 0; right < length; right ++) {
            char ch = s.charAt(right);
            int idx = ch;
            if (index[idx] != -1) {
                left = Math.max(left, index[idx] + 1);
            }
            maxsub = Math.max(maxsub, right - left + 1);
            index[idx] = right;
        }
        return maxsub;
    }
}
