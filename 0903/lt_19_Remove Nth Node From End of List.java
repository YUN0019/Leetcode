/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * Time Complexity: O(L)
     * 說明：快慢指針一次遍歷鏈表；快指針先走 n 步，之後同步前進直到快指針到尾，
     * 此時慢指針位於待刪節點的前一個節點，整體只需線性掃描一次。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先讓 fast 前進 n+1 步，使 slow 停在待刪前一個
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 刪除 slow 後面的節點
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/*
解題邏輯與思路（雙指針 + 假頭節點）：
1. 以 `dummy -> head` 作為假頭，方便處理刪除頭節點等邊界。
2. 讓 `fast` 先走 n+1 步，維持 fast 與 slow 之間間距為 n+1。
   之後兩者同步前進，當 fast 抵達尾端（null）時，slow 正好位於待刪節點的前一個。
3. 執行 `slow.next = slow.next.next` 完成刪除並返回 `dummy.next`。
4. 時間 O(L)，空間 O(1)。
*/
