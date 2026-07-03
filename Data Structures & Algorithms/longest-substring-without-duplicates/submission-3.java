class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[512];
        Arrays.fill(index, -1);
        int maxsub = 0, length = s.length();
        for (int left=0, right = 0; right < length; right ++) {
            char ch = s.charAt(right);
            int idx = ch;
            if (index[idx] != -1 && left < (index[idx] +1)) {
                left = index[idx] +1;
            }
            maxsub = Math.max(maxsub, right - left + 1);
            index[idx] = right;
        }
        return maxsub;
    }
}


/**

abba - 
1. Array fill with -1
2. left = 0 , right = 0
        'z' - 127
        maxsub = 1
        arr[127] = 0
3. left = 0 , right = 1
        'x' - 125
        maxsub = 2
        arr[125] = 1
4. left = 0 , right =2 , maxsub = 3, arr[126] = 2
5. left = 0 . right =3,
        ! = -1
            left = 1
            arr[127] = 3 - store        

**/