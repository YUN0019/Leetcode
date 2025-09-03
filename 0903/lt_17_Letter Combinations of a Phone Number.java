import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /*
     * Time Complexity: O(3^m * 4^k)
     * 說明：m 與 k 分別為對應 3 個字母與 4 個字母的數位個數；
     * 需要生成所有組合，因此時間與輸出規模同階；回溯額外空間 O(m+k)。
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path,
                           Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path, map, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/*
解題邏輯與思路（回溯/DFS）：
1. 手機九宮格每個數位對應固定字母集合（2→abc, 3→def, ...）。
2. 以回溯構造所有可能字串：
   - 狀態為目前處理到的數位 index 與已選字元 path。
   - 到達長度等於 digits 時，產生一個完整組合，加入結果。
   - 否則遍歷當前數位對應的所有字母，選擇→遞迴→撤銷，繼續探索。
3. 由於需要輸出全部組合，時間與結果數量同階 O(3^m 4^k)，額外遞迴深度 O(len)。
*/
