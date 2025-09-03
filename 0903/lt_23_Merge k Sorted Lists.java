// package 名稱不能以數字開頭，建議加底線或修改

import java.util.PriorityQueue;

// LeetCode 會自動提供 ListNode 類別，這裡不用再定義

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        // 使用最小堆（優先隊列）來每次取出當前最小的節點
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 將每個鏈表的頭節點加入優先隊列
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // 建立虛擬頭節點，方便操作
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 每次從優先隊列取出最小節點，並將其 next 節點加入隊列
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next; // 返回合併後的鏈表頭節點
    }
}

// 解題思路：
// 1. 這題要合併 k 個已排序的鏈表，可以用最小堆（優先隊列）來每次取得當前最小的節點。
// 2. 先將每個鏈表的頭節點放進優先隊列，然後每次取出最小的節點，並把該節點的 next 加入隊列。
// 3. 這樣可以保證每次取出的節點都是目前所有鏈表中最小的，最終合併成一條有序鏈表。
// 4. 時間複雜度為 O(N log k)，N 為所有節點總數，k 為鏈表數量
