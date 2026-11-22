class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0, col = 0; row < 9; row++, col++) {
            boolean[] rowDigits = new boolean[10];
            boolean[] colDigits = new boolean[10];
            for (int index = 0; index < 9; index++) {
                if (board[row][index] != '.') {
                    int digit = board[row][index] - '0';
                    if (rowDigits[digit]) {
                        return false;
                    }
                    rowDigits[digit] = true;
                }
                if (board[index][col] != '.') {
                    int digit = board[index][col] - '0';
                    if (colDigits[digit]) {
                        return false;
                    }
                    colDigits[digit] = true;
                }
            }
        }
        for (int row = 0; row < 9 ; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] digits3x3 = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[row + i][col + j] == '.') {
                            continue;
                        }
                        int digit = board[row + i][col + j] - '0';
                        if (digits3x3[digit]) {
                            return false;
                        }
                        digits3x3[digit] = true;
                    }
                }
            }
        }
        return true;
    }
    // I check every 3 x 3 across 9 x 9 board
    // In the 3x3 check i have to take the num that filled in current box should not be in whole row and col and as well in the same box
    // by above conditions i can say the given soduku is valid or not
    // as per qn i can take every rows and columns check for duplicates first and then 3x3?
    // It seems go by the rule seems better. 
}
