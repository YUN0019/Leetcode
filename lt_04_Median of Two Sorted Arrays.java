class Solution {
    /*
     * Time Complexity: O(log(min(m, n)))
     * 說明：使用二分查找在較短的數組上進行分割，每次排除一半的元素
     * 總共需要log(min(m, n))次迭代，每次迭代的比較操作是常數時間
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 確保nums1是較短的數組
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        
        while (left <= right) {
            // 在nums1中的分割點
            int partitionX = (left + right) / 2;
            // 在nums2中的分割點
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            // 計算分割點左右的值
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // 檢查分割是否正確
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // 找到正確的分割點
                if ((m + n) % 2 == 0) {
                    // 偶數個元素，返回兩個中間值的平均
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // 奇數個元素，返回左半部分的最大值
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // nums1的左半部分太大，需要向左移動
                right = partitionX - 1;
            } else {
                // nums1的右半部分太小，需要向右移動
                left = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
