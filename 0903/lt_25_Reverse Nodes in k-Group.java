// LeetCode 會自動提供 ListNode 類別，這裡不用再定義

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 建立虛擬頭節點，方便處理頭部反轉
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 檢查剩下的節點數是否 >= k
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // 不足 k 個，不反轉

            // 反轉 k 個節點
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;
            // 斷開與後面連結
            kth.next = null;

            // 反轉這一段
            prevGroupEnd.next = reverse(groupStart);

            // 反轉後 groupStart 變成這段的尾巴，接回剩下的鏈表
            groupStart.next = nextGroupStart;

            // prevGroupEnd 移動到下一組的尾巴
            prevGroupEnd = groupStart;
        }

        return dummy.next; // 返回新的頭節點
    }

    // 反轉單鏈表
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// 解題思路：
// 1. 每次檢查剩下的節點是否有 k 個，若不足 k 個則不反轉。
// 2. 若有 k 個，則將這 k 個節點斷開並反轉，然後接回原鏈表。
// 3. 使用虛擬頭節點 dummy，方便處理頭部反轉與連接。
// 4. 反轉時只需調整指標，不需改變節點值，符合題目要求。
// 5. 時間複雜度 O(n)，n 為鏈表長度，每個節點最多被訪問兩次。
