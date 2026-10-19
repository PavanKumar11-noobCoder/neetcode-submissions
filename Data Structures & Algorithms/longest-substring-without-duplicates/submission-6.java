class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int longest = 0;
        for (int left = 0, right = 0; right < len; right++) {
            char ch = s.charAt(right);
            if (hash[ch] != -1) {
                left = Math.max(left, hash[ch] + 1);
            }
            longest = Math.max(longest, right - left + 1);
            hash[ch] = right;
        }
        return longest;
    }
}
