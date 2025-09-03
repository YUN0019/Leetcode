import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * Time Complexity: O(n log n + n^2) = O(n^2)
     * 說明：先排序 O(n log n)，再固定一個索引 i，使用左右指針在其右側做二和為 -nums[i] 的搜尋，
     * 內層雙指針總計 O(n) 且對 i 執行約 n 次，因此主體為 O(n^2)。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳過重複的首元素
            if (nums[i] > 0) break; // 排序後首元素>0，不可能和為0

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳過重複
                    int leftVal = nums[left];
                    int rightVal = nums[right];
                    while (left < right && nums[left] == leftVal) left++;
                    while (left < right && nums[right] == rightVal) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

/*
解題邏輯與思路（排序 + 雙指針）：
1. 先對陣列排序，使得相同數字相鄰，並可使用左右指針在線性時間內完成二和搜尋。
2. 迭代每個位置 i 作為三元組的第一個數，目標轉為在區間 [i+1, n-1] 找到兩數之和 = -nums[i]。
3. 透過 left、right 指針：
   - 若 nums[left] + nums[right] == -nums[i]，收錄三元組並跳過所有相同值避免重複。
   - 若和較小，left++；若和較大，right--。
4. 重要去重：
   - 外層 i 與前一個值相同則 continue；
   - 內層在加入結果後，分別移動 left/right 跳過相同值。
5. 複雜度：排序 O(n log n)；主循環固定 i 並以雙指針掃描 O(n) → 總計 O(n^2)，空間 O(1)（不含輸出）。
*/
