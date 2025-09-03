public class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) { // 從頭到尾遍歷 haystack，最多到 n-m
            if (haystack.substring(i, i + m).equals(needle)) { // 比較子字串是否等於 needle
                return i; // 找到第一個出現的位置就回傳
            }
        }
        return -1; // 沒找到則回傳 -1
    }
}

// 解題思路：
// 1. 直接遍歷 haystack，對每個可能的起始位置取長度為 needle.length() 的子字串，判斷是否等於 needle。
// 2. 若找到則回傳該起始索引，否則最後回傳 -1。
// 3. 時間複雜度 O((n-m+1)*m)，n 為 haystack 長度，m 為 needle 長度。
// 4. 這是最直接的暴力解法，適合本題數據範
