class Solution {
    /*
     * Time Complexity: O(n^2)
     * 說明：使用中心擴展算法，以每個字符和字符間隙為中心向兩邊擴展
     * 總共有2n-1個中心點，每個中心點最多擴展n/2次
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // 以單個字符為中心（奇數長度回文）
            int len1 = expandAroundCenter(s, i, i);
            // 以兩個字符之間為中心（偶數長度回文）
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int currentMaxLength = Math.max(len1, len2);
            
            if (currentMaxLength > maxLength) {
                maxLength = currentMaxLength;
                start = i - (currentMaxLength - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
