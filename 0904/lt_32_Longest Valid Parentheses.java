public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int left = 0, right = 0;
        // 從左到右掃描
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        // 從右到左再掃描一次
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }
}

// 解題思路：
// 1. 先從左到右掃描，遇到 '(' left++，遇到 ')' right++，當 left==right 時更新最大長度。
// 2. 若 right > left，代表不可能有合法子串，歸零重新計算。
// 3. 再從右到左掃描一次，這次遇到 left > right 時歸零，確保所有情況都能覆蓋。
// 4. 時間複雜度 O(n)，空間複