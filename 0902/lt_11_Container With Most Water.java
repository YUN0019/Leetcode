class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：使用雙指針從兩端向中間移動，每次移動較短的邊以嘗試獲得更大面積；
     * 兩個指針各自最多移動 n 次，因此總時間為線性。
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

/*
解題邏輯與思路（雙指針）：
1. 直觀暴力法是枚舉所有兩條邊，面積 = min(h[i], h[j]) * (j - i)，但為 O(n^2)。
2. 觀察：面積受「短邊」限制。若想增大面積，必須嘗試找到更高的短邊，同時盡量保持寬度。
3. 因此使用左右指針：
   - 初始 left=0、right=n-1，這時寬度最大。
   - 每步計算當前面積，更新答案。
   - 比較兩端高度：
       · 若左邊較短，移動 left++（期望找到更高的左邊，才可能突破由短邊造成的瓶頸）。
       · 否則移動 right--（同理）。
4. 證明要點：移動較高的那一側不可能得到更大面積，因為短邊不變或更短且寬度更小；
   只有移動較短的一側才有機會把短邊變高，從而在寬度減少的同時仍可能獲得更大面積。
5. 兩指針最多各移動 n 次，時間 O(n)，只用常數額外空間 O(1)。
*/
