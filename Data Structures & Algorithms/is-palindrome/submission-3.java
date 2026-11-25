class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }
            if ((arr[left] & '_') != (arr[right] & '_')) return false;
            left++;
            right--;
        }
        return left >= right;
    }

}
