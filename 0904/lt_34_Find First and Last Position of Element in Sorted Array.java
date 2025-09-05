public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findFirst(nums, target); // 找到第一個出現的位置
        res[1] = findLast(nums, target);  // 找到最後一個出現的位置
        return res;
    }

    // 二分搜尋找第一個出現的位置
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // 繼續往左找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 二分搜尋找最後一個出現的位置
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // 繼續往右找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

// 解題思路：
// 1. 用兩次二分搜尋分別找 target 的第一個和最後一個出現位置。
// 2. 若沒找到則回傳 [-1, -1]，找到則回傳 [first, last]。
// 3. 時間複雜度 O(log n)，符合題目要