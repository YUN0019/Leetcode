class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * Time Complexity: O(m + n)
     * 說明：依序比較兩條已排序鏈表的當前節點，總共僅走過每個節點一次。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}

/*
解題邏輯與思路（雙指針就地串接）：
1. 使用假頭 `dummy` 與尾指針 `tail`。
2. 同步遍歷 `list1`、`list2`：每次取較小值節點接到 `tail` 後，移動對應鏈表與 `tail`。
3. 其中一條走完後，將另一條剩餘部分直接接上。
4. 返回 `dummy.next` 即為合併後的升序鏈表。時間 O(m+n)，空間 O(1)。
*/
