/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个节点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode pre = head; // 先走的指针
        ListNode cur = head; // 当前的指针

        // pre先走k-1步
        for (int i = 0; i < k - 1; i++) {
            if (pre.next != null)
                pre = pre.next;
            else
                return null;
        }

        // 当pre到尾cur就是倒数第K个节点
        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        return cur;
    }
}
