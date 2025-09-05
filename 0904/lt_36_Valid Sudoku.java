public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 檢查每一列、每一行、每一個 3x3 區塊
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) { // 遍歷每一列
            for (int j = 0; j < 9; j++) { // 遍歷每一行
                if (board[i][j] == '.') continue; // 空格跳過
                int num = board[i][j] - '1'; // 將 '1'-'9' 轉成 0-8
                int boxIdx = (i / 3) * 3 + (j / 3); // 計算 3x3 區塊的索引
                if (row[i][num] || col[j][num] || box[boxIdx][num]) {
                    return false; // 若已出現過，則不是有效數獨
                }
                row[i][num] = true;
                col[j][num] = true;
                box[boxIdx][num] = true;
            }
        }
        return true;
    }
}

// 解題思路：
// 1. 用三個 9x9 的布林陣列分別記錄每一列、每一行、每一個 3x3 區塊是否出現過某個數字。
// 2. 遍歷整個 board，對於每個非 '.' 的格子，檢查該數字在對應的列、行、區塊是否已出現過。
// 3. 若有重複則回傳 false，否則標記已出現。
// 4. 全部檢查完沒問題則回傳 true。
// 5. 時間複雜度 O(1)，因為 board 固定為