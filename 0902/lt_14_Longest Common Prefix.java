class Solution {
    /*
     * Time Complexity: O(n * m)
     * 說明：n 為字串個數、m 為最短字串長度。
     * 逐字元比對所有字串的同一索引，最壞需比對到最短字串結尾。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int s = 1; s < strs.length; s++) {
                if (i >= strs[s].length() || strs[s].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        return first; // 全部匹配，第一個字串即為最長公共前綴
    }
}

/*
解題邏輯與思路（逐位比對/水平掃描）：
1. 以第一個字串作為基準，從索引 0 開始逐位檢查所有字串是否都具有相同字元。
2. 一旦有某個字串在該位置不存在（長度不足）或字元不同，
   代表公共前綴在此處結束，答案為基準字串的子字串 [0, i)。
3. 若整個基準字串皆通過比對，則其本身即為最長公共前綴。
4. 時間 O(n*m)（n 個字串、比到最短字串長度 m），空間 O(1)。
*/
