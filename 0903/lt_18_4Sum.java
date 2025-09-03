import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * Time Complexity: O(n^3)
     * 說明：排序 O(n log n) 後，外層固定兩個索引 i、j，內層使用雙指針線性掃描；
     * 兩層固定約 O(n^2) × 雙指針 O(n) → O(n^3)。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // i 去重
            // 下界剪枝：最小可能和大於 target，則後續 i 只會更大，直接結束
            long minSumI = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSumI > (long)target) break;
            // 上界剪枝：最大可能和小於 target，則換下一個 i
            long maxSumI = (long)nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxSumI < (long)target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // j 去重
                // 對 j 再做下界/上界剪枝
                long minSumJ = (long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSumJ > (long)target) break;
                long maxSumJ = (long)nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxSumJ < (long)target) continue;

                long twoTarget = (long)target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long)nums[left] + nums[right];
                    if (sum == twoTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        int leftVal = nums[left];
                        int rightVal = nums[right];
                        while (left < right && nums[left] == leftVal) left++;
                        while (left < right && nums[right] == rightVal) right--;
                    } else if (sum < twoTarget) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++; // 去重
                    } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--; // 去重
                    }
                }
            }
        }

        return result;
    }
}

/*
解題邏輯與思路（排序 + 雙層枚舉 + 內層雙指針）：
1. 先排序，便於去重與雙指針移動。
2. 外層固定第一、第二個元素索引 i、j；將目標轉為 twoTarget = target - nums[i] - nums[j]。
3. 內層在區間 [j+1, n-1] 使用左右指針找兩數之和 = twoTarget：
   - 命中即加入答案，並分別跳過與 left/right 相同的值以避免重複四元組；
   - 若和較小，left++；若和較大，right--。
4. 兩層固定各 O(n)，內層線性 O(n)，總複雜度 O(n^3)；空間 O(1)（不含輸出）。
*/
