public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // base case

        String prev = countAndSay(n - 1); // 先取得前一項
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currChar = prev.charAt(0);

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currChar) {
                count++; // 相同字元累加
            } else {
                sb.append(count).append(currChar); // 不同則記錄
                currChar = prev.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(currChar); // 最後一段也要記錄

        return sb.toString();
    }
}

// 解題思路：
// 1. 遞迴取得前一項的 count-and-say 字串。
// 2. 對前一項進行 run-length encoding，遇到不同字元就把累計次數和字元加到結果。
// 3. 重複直到 n==1 為止。
// 4. 時間複雜度 O(2^n)，但 n <= 30 時可