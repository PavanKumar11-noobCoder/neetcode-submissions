class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoding = new StringBuilder();
        for (int index = 0; index < strs.size(); index++) {
            encoding.append(strs.get(index)).append("|");
            if (index + 1 < strs.size()) {
                encoding.append(257);
            }
        }
        return encoding.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for (String word : str.split("257")) {
            int newLen = word.length();
            if (newLen == 0) {
                continue;
            }
            ans.add(word.substring(0, newLen - 1));
        }
        return ans;
    }
}
