/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode cur = pre.next;
        ListNode next;

        while (cur != null && cur.next != null) {
            next = cur.next;
            if (cur.val == next.val) {
                next = next.next;
                while (next != null && cur.val == next.val)
                    next = next.next;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        删除链表中重复的结点 test = new 删除链表中重复的结点();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        test.deleteDuplication(listNode1);
    }
}
