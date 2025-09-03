import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * Time Complexity: O(Catalan(n))
     * 說明：合法括號組合數量為第 n 個卡特蘭數，回溯需枚舉所有解；
     * 每次遞迴追加/撤銷一個字元，額外空間為遞迴深度 O(n)。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int open, int close, StringBuilder path, List<String> result) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            backtrack(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            backtrack(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/*
解題邏輯與思路（回溯 + 剪枝）：
1. 用 `open`、`close` 記錄已放入的左右括號數。
2. 規則：
   - 只要 `open < n` 就能放 '('；
   - 只有在 `close < open` 時才能放 ')'，以保證任一前綴不會右括號多於左括號。
3. 當長度達到 2n 時產生一個解。時間與解數量同階（卡特蘭數），空間為遞迴深度 O(n)。
*/
