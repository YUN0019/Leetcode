class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：只需要遍歷字符串一次，處理前導空白、符號和數字
     * 每個字符最多被訪問一次，其中n是字符串長度
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int index = 0;
        int sign = 1;
        long result = 0;
        
        // Step 1: 跳過前導空白字符
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index >= s.length()) {
            return 0;
        }
        
        // Step 2: 處理符號
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        
        // Step 3: 讀取數字
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;
            
            // 檢查溢出
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && result > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            index++;
        }
        
        return (int) (sign * result);
    }
}
