public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid; // 找到直接回傳

            // 判斷哪一半是有序的
            if (nums[left] <= nums[mid]) { // 左半邊有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target 在左半邊
                } else {
                    left = mid + 1; // target 在右半邊
                }
            } else { // 右半邊有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target 在右半邊
                } else {
                    right = mid - 1; // target 在左半邊
                }
            }
        }
        return -1; // 沒找到回傳 -1
    }
}

// 解題思路：
// 1. 使用二分搜尋法，時間複雜度 O(log n)。
// 2. 每次判斷 mid 左右哪一半是有序的，根據 target 落在有序區間還是無序區間決定搜尋方向。
// 3. 若找到 target 則回傳索引，否則最後回傳