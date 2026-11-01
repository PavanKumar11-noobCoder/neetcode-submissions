class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            loadCharsCount(anagrams, str);
        }
        return new ArrayList<>(anagrams.values());
    }

    void loadCharsCount(Map<String, List<String>> map, String str) {
        int[] hash = new int[26];
        for (int index = 0; index < str.length(); index++) {
            hash[str.charAt(index) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int ch = 0; ch < 26; ch++) {
            while (hash[ch] > 0) {
                sb.append((char)(ch + 'a'));
                hash[ch]--;
            }
        }
        String arranged = sb.toString();
        List<String> list = map.getOrDefault(arranged, new ArrayList<>());
        list.add(str);
        map.putIfAbsent(arranged, list);
    }

}