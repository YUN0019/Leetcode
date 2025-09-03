// LeetCode 會自動提供 ListNode 類別，這裡不用再定義

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 建立虛擬頭節點，方便處理頭節點交換
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // 每次檢查 curr 後面有沒有兩個節點可交換
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;         // 第一個節點
            ListNode second = curr.next.next;   // 第二個節點

            // 交換節點
            first.next = second.next;
            second.next = first;
            curr.next = second;

            // curr 往後移動兩格，準備交換下一對
            curr = first;
        }

        return dummy.next; // 返回新的頭節點
    }
}

// 解題思路：
// 1. 使用虛擬頭節點 dummy，方便處理頭節點交換的情況。
// 2. 每次檢查當前節點後面有沒有兩個節點可交換，若有則進行交換。
// 3. 交換時只需調整指標，不需改變節點值，符合題目要求。
// 4. 最後返回 dummy.next 即為交換後的新鏈表頭。
// 5. 時間複雜度 O(n)，n 為鏈表長度
