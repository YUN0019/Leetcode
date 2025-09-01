class Solution {
    /*
     * Time Complexity: O(log|x|)
     * 說明：反轉一個數字的位數取決於該數字的位數，即log10(|x|)
     * 每次迭代都將數字除以10，直到數字變為0
     */
    public int reverse(int x) {
        long reversedNum = 0; // 使用long來處理潛在的溢出，之後再檢查是否在int範圍內
        
        while (x != 0) {
            int digit = x % 10; // 取出最後一位
            reversedNum = reversedNum * 10 + digit; // 將數字添加到反轉數的末尾
            x /= 10; // 移除最後一位
        }
        
        // 檢查反轉後的數字是否超出32位有符號整數的範圍
        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) reversedNum;
    }
}
