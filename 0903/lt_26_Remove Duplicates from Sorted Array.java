public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // 若陣列為空，直接回傳0

        int slow = 1; // 慢指針，指向下個要放唯一元素的位置
        for (int fast = 1; fast < nums.length; fast++) { // 快指針遍歷陣列
            if (nums[fast] != nums[fast - 1]) { // 若當前元素與前一個不同，表示是新元素
                nums[slow] = nums[fast]; // 將新元素放到慢指針位置
                slow++; // 慢指針往後移
            }
        }
        return slow; // 回傳唯一元素的個數
    }
}

// 解題思路：
// 1. 由於陣列已排序，相同元素會相鄰。
// 2. 使用雙指針法：快指針遍歷陣列，慢指針標記下個唯一元素要放的位置。
// 3. 當快指針遇到新元素時，將其複製到慢指針位置，然後慢指針前進。
// 4. 最後慢指針的位置即為唯一元素個數，也是要回傳的答案。
// 5. 時間複雜度 O(n)，空間複雜度 O(1)
