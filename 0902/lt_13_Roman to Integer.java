import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：單趟掃描字串一次，對每個字符進行常數次查表與比較；
     * 若前一個值小於當前值，做減法修正，因此總時間為線性。
     */
    public int romanToInt(String s) {
        Map<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int total = 0;
        int prev = 0; // 上一個符號的值
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = value.get(s.charAt(i));
            if (curr < prev) {
                total -= curr; // 減法情形：IV, IX, XL, XC, CD, CM
            } else {
                total += curr;
            }
            prev = curr;
        }
        return total;
    }
}

/*
解題邏輯與思路（從右往左掃描 + 減法規則）：
1. 建立羅馬符號到整數的映射：I=1, V=5, X=10, L=50, C=100, D=500, M=1000。
2. 羅馬數字多為由大到小相加，唯有六種減法情況：IV, IX, XL, XC, CD, CM。
3. 掃描策略：由右至左遍歷字串，保存上一個（右側）值 prev。
   - 若當前值 < prev，表示屬於減法，total 減去當前值。
   - 否則為一般加法，total 加上當前值。
4. 如此一次遍歷即可完成轉換，時間 O(n)，空間 O(1)（映射可視為常數大小）。
*/
