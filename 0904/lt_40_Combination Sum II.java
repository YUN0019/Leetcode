import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先排序，方便去重
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path)); // 找到一組解
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // 跳過重複數字
            if (candidates[i] > target) break; // 剪枝
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res); // 每個數只能用一次
            path.remove(path.size() - 1); // 回溯
        }
    }
}

// 解題思路：
// 1. 先對 candidates 排序，方便去重。
// 2. 用回溯法，每次遞迴時從 start 開始，每個數只能用一次（i+1）。
// 3. 若遇到重複數字（i > start && candidates[i] == candidates[i-1]），則跳過，避免重複組合。
// 4. 當 target == 0 時，加入結果。
// 5. 時間複雜度最壞 O(2^n)，但數據範圍內