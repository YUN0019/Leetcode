class Solution {
    /*
     * Time Complexity: O(log|x|)
     * 說明：只需要反轉數字的一半位數，比較前半部分和後半部分
     * 反轉的位數等於原數字的位數的一半，即log10(|x|)/2
     */
    public boolean isPalindrome(int x) {
        // 負數不可能是回文數（因為有負號）
        if (x < 0) {
            return false;
        }
        
        // 如果數字以0結尾，只有0本身是回文數
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        
        int reversed = 0;
        // 只反轉後半部分數字
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        // 當數字位數為奇數時，需要去掉中間的數字
        // 例如：12321，x=12，reversed=123，需要比較x和reversed/10
        return x == reversed || x == reversed / 10;
    }
}
