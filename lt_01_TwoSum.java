import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * Time Complexity: O(n)
     * 說明：使用HashMap存儲每個數字及其索引，只需遍歷數組一次
     * 每次查找complement的時間複雜度為O(1)，總共n次操作
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        // 根據題目假設，總會有一個解，所以這裡不會執行到
        return new int[]{};
    }
}