public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 從右往左找到第一個遞減的位置
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 從右往左找到第一個比 nums[i] 大的數
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交換 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        // 將 i 之後的數字反轉
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

// 解題思路：
// 1. 從右往左找到第一個遞減的位置 i，若找不到則整個陣列已是最大排列，直接反轉為最小排列。
// 2. 若找到 i，則從右往左找到第一個比 nums[i] 大的數 j，交換 nums[i] 和 nums[j]。
// 3. 最後將 i 之後的數字反轉，使其為最小排列。
// 4. 時間複雜度 O(n)，空間複雜
