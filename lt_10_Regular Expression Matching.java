class Solution {
    /*
     * Time Complexity: O(m*n)
     * 說明：使用動態規劃，dp[i][j]表示s的前i個字符與p的前j個字符是否匹配
     * 需要填充m*n的dp表，每個狀態的計算是常數時間
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] 表示 s的前i個字符與p的前j個字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // 空字符串與空模式匹配
        dp[0][0] = true;
        
        // 處理模式中的*號（空字符串與模式的匹配情況）
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // 填充dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // 當前字符匹配
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 處理*號
                    dp[i][j] = dp[i][j - 2]; // 匹配0次
                    
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        // 匹配1次或多次
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
