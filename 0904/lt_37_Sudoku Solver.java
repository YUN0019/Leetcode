public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    // 回溯法遞迴解數獨
    private boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) { // 換到下一列
            row++;
            col = 0;
        }
        if (row == 9) return true; // 填完所有格子，解成立

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1); // 已有數字，跳到下一格
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c; // 嘗試填入 c
                if (backtrack(board, row, col + 1)) return true; // 若能解出直接回傳
                board[row][col] = '.'; // 回溯，還原
            }
        }
        return false; // 9 個數字都不行，回溯
    }

    // 檢查填入 c 是否有效
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // 檢查列
            if (board[i][col] == c) return false; // 檢查行
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false; // 檢查 3x3 區塊
        }
        return true;
    }
}

// 解題思路：
// 1. 用回溯法遞迴嘗試填入每個空格，對每個空格嘗試 1~9。
// 2. 每次填入前檢查該數字在該列、行、3x3 區塊是否已出現過。
// 3. 若能填到底（row==9），代表找到一組解，直接返回。
// 4. 若 1~9 都不行則回溯，還原該格。
// 5. 時間複雜度最壞 O(9^(n^2))，但實際上剪枝後很快