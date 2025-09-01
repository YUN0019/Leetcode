import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：使用滑動窗口算法，每個字符最多被訪問兩次（加入和移除窗口）
     * 使用HashMap記錄字符位置，實現O(1)時間複雜度的查找
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // 如果字符已經存在，更新起始位置
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            
            // 更新字符位置
            map.put(currentChar, end);
            
            // 更新最大長度
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
