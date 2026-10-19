class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] hash = new int[128];
        Arrays.fill(hash, -1);
        int longestStr = 0, lastIndex = 0;
        for (int index = 0; index < len; index++) {
            char ch = s.charAt(index);
            if (hash[ch] != -1) {
                lastIndex = Math.max(lastIndex, hash[ch] + 1);
            }
            longestStr = Math.max(longestStr, index - lastIndex + 1);
            hash[ch] = index;
        }
        return longestStr;
    }
}
