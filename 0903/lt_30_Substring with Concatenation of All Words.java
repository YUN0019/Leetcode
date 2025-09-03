import java.util.*;

public class Solution { // 類別名稱需為 Solution，LeetCode 才能正確呼叫
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int wordLen = words[0].length(); // 每個單字長度
        int wordCount = words.length;    // 單字數量
        int totalLen = wordLen * wordCount; // 所有單字連接後的總長度

        // 統計 words 中每個單字出現的次數
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 遍歷 s 的每個可能起始點
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordCount) {
                int start = i + j * wordLen;
                String sub = s.substring(start, start + wordLen); // 取出當前單字
                if (!wordMap.containsKey(sub)) break; // 不在 words 裡，直接跳出
                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                if (seen.get(sub) > wordMap.get(sub)) break; // 出現次數超過，跳出
                j++;
            }
            if (j == wordCount) res.add(i); // 若全部單字都符合，記錄起始索引
        }
        return res;
    }
}

// 解題思路：
// 1. 先統計 words 中每個單字出現的次數（用 HashMap）。
// 2. 對於 s 的每個可能起始點，檢查長度為 words.length * wordLen 的子字串，是否能由 words 中所有單字組成（順序不限）。
// 3. 用另一個 HashMap 統計當前區間內每個單字出現次數，若有不符則跳出。
// 4. 若全部單字都符合，則記錄該起始索引。
// 5. 時間複雜度 O((n - totalLen + 1) * wordCount * wordLen)，n 為 s 長
