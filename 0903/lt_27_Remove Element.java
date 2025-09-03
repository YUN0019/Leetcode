public class Solution { // 類別名稱需為 Solution，LeetCode 才能正確呼叫
    public int removeElement(int[] nums, int val) {
        int slow = 0; // 慢指針，指向下個要放非 val 元素的位置
        for (int fast = 0; fast < nums.length; fast++) { // 快指針遍歷陣列
            if (nums[fast] != val) { // 如果當前元素不是要移除的 val
                nums[slow] = nums[fast]; // 將其放到慢指針位置
                slow++; // 慢指針往後移
            }
        }
        return slow; // 回傳剩下非 val 元素的個數
    }
}

// 解題思路：
// 1. 使用雙指針法：快指針遍歷陣列，慢指針標記下個非 val 元素要放的位置。
// 2. 當快指針遇到不是 val 的元素時，將其複製到慢指針位置，然後慢指針前進。
// 3. 最後慢指針的位置即為剩下非 val 元素的個數，也是要回傳的答案。
// 4. 題目要求 in-place 操作，且不需考慮超過 k 之後的內容。
// 5. 時間複雜度 O(n)，空間複
