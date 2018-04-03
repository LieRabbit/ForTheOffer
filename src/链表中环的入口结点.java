/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode fast = pHead.next.next, node = pHead.next;

        while (fast != node) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                node = node.next;
            } else
                return null;
        }

        fast = pHead;

        while (fast != node) {
            fast = fast.next;
            node = node.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        链表中环的入口结点 test = new 链表中环的入口结点();
        System.out.println(test.EntryNodeOfLoop(new ListNode(1)));
    }
}
