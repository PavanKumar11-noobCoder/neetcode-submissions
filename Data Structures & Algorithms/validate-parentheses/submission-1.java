class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                boolean checkOpen = switch (ch) {
                    case ')' -> stack.peek() == '(';
                    case '}' -> stack.peek() == '{';
                    case ']' -> stack.peek() == '[';
                    default -> false;
                };
                if (!checkOpen) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
