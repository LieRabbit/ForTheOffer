/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {
    public ListNode Merge(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        else if (node2 == null)
            return node1;

        ListNode node;

        if (node1.val < node2.val) {
            node = node1;
            node.next = Merge(node1.next, node2);
        } else {
            node = node2;
            node.next = Merge(node1, node2.next);
        }

        return node;
    }
}
