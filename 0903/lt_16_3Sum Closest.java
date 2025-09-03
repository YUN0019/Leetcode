import java.util.Arrays;

class Solution {
    /*
     * Time Complexity: O(n^2)
     * 說明：先排序 O(n log n)，再固定一個索引，使用左右指針做線性掃描 O(n)；
     * 外層約 n 次，因此主體為 O(n^2)，排序被漸進支配。
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int bestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }
                if (sum == target) {
                    return target; // 已最接近
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return bestSum;
    }
}

/*
解題邏輯與思路（排序 + 雙指針）：
1. 將陣列排序，便於在固定第一個元素後，使用左右指針調整另外兩個元素的和。
2. 對每個 i：
   - 設 left=i+1、right=n-1，計算 sum=nums[i]+nums[left]+nums[right]。
   - 以 |sum-target| 與目前 best 的差距比較，較小者更新為答案。
   - 若 sum < target，表示需要更大總和，left++；若 sum > target，right--。
   - 若恰好等於 target，直接返回 target（已是最接近）。
3. 外層 n 次、內層雙指針線性掃描，時間 O(n^2)，額外空間 O(1)。
*/
