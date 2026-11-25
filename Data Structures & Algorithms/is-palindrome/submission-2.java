class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < arr.length && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            while (right >= 0 && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }
            // System.out.printf("%d %d\n", left, right);
            if (left < arr.length && right >= 0 && (arr[left] & '_') != (arr[right] & '_')) return false;
            left++;
            right--;
        }
        return left >= right;
    }

}
