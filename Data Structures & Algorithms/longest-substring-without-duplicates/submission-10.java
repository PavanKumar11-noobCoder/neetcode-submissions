class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] hash = new int[128];
        int longestStr = 0, lastIndex = 0;
        for (int index = 0; index < len; index++) {
            char ch = s.charAt(index);
            lastIndex = Math.max(lastIndex, hash[ch]);
            longestStr = Math.max(longestStr, index - lastIndex + 1);
            hash[ch] = index + 1;
        }
        return longestStr;
    }
}
