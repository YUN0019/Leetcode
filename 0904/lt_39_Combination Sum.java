import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    // 回溯法
    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path)); // 找到一組解
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // 剪枝
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, res); // 可重複使用同一個數
            path.remove(path.size() - 1); // 回溯
        }
    }
}

// 解題思路：
// 1. 用回溯法（backtracking）遞迴嘗試每個數字，每次可以重複選取同一個數。
// 2. 當 target == 0 時，代表找到一組組合，加入結果。
// 3. 每次遞迴從當前 start 開始，確保組合唯一且不重複。
// 4. 若 candidates[i] > target 則剪枝。
// 5. 時間複雜度最壞 O(2^target)，但數據範圍內可接