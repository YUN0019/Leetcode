public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // 找到直接回傳
            } else if (nums[mid] < target) {
                left = mid + 1; // target 在右邊
            } else {
                right = mid - 1; // target 在左邊
            }
        }
        return left; // 沒找到，left 即為插入位置
    }
}

// 解題思路：
// 1. 使用二分搜尋法尋找 target，若找到則回傳索引。
// 2. 若沒找到，left 會停在第一個大於 target 的位置，即為插入點。
// 3. 時間複雜度 O(log n)，空間