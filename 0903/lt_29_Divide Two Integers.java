public class Solution {
    public int divide(int dividend, int divisor) {
        // 處理溢位情況
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // 超過 int 範圍，回傳最大值
        }

        // 取絕對值並轉為 long，避免溢位
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;

        // 用減法和位移模擬除法
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        // 根據正負號決定結果正負
        return ((dividend > 0) == (divisor > 0)) ? result : -result;
    }
}

// 解題思路：
// 1. 不能用乘除與取餘運算，只能用加減與位運算模擬除法。
// 2. 先將 dividend 和 divisor 轉成 long 並取絕對值，避免溢位。
// 3. 用減法和位移（左移相當於乘2）加速計算，每次儘量減去最大的 2^n * divisor。
// 4. 累加減去的次數即為商，最後根據原本的正負號決定結果正負。
// 5. 注意特殊情況（如溢位），時間複雜
