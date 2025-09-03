class Solution {
    /*
     * Time Complexity: O(1)
     * 說明：羅馬數字僅有固定面額，最多處理 13 種面額且每位數最多處理 3~4 次，
     * 因此操作次數為常數上界；相較以 n 表示輸入數值大小，視為常數時間。
     */
    public String intToRoman(int num) {
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
        };
        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            if (num == 0) break;
        }
        return sb.toString();
    }
}

/*
解題邏輯與思路（貪心 + 面額表）：
1. 羅馬數字由固定面額組成，且允許六種「減法表示」：IV, IX, XL, XC, CD, CM。
2. 將面額與符號依由大到小列成對齊陣列：
   [1000(M), 900(CM), 500(D), 400(CD), 100(C), 90(XC), 50(L), 40(XL), 10(X), 9(IX), 5(V), 4(IV), 1(I)]。
3. 從最大面額起，能減幾次就減幾次並附加相對應符號（典型貪心策略）。
   因為較大的面額總是更接近目標且不會阻礙最優性，羅馬數字定義亦保證此策略正確。
4. 面額數量固定且每個面額最多被使用少數次，故時間 O(1)，空間 O(1)。
*/
