class Solution {
    public boolean isAnagram(String s, String t) {
        int[] str1Hash = new int[26];
        int[] str2Hash = new int[26];

        for (int index = 0; index < s.length(); index++) {
            str1Hash[s.charAt(index) - 'a']++;
        }

        for (int index = 0; index < t.length(); index++) {
            str2Hash[t.charAt(index) - 'a']++;
        }

        for (int ch = 0; ch < 26; ch++) {
            if (str1Hash[ch] != str2Hash[ch]) {
                return false;
            }
        }
        return true;
    }
}
