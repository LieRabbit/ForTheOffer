/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        int count1 = 0;
        int count2 = 0;
        ListNode node1 = pHead1;
        while (node1 != null) {
            count1++;
            node1 = node1.next;
        }
        ListNode node2 = pHead2;
        while (node2 != null) {
            count2++;
            node2 = node2.next;
        }
        node1 = pHead1;
        node2 = pHead2;
        int count3;
        if (count1 > count2) {
            count3 = count1 - count2;
            while (count3 > 0) {
                count3--;
                node1 = node1.next;
            }
        } else {
            count3 = count2 - count1;
            while (count3 > 0) {
                count3--;
                node2 = node2.next;
            }
        }
        while (node1 != null) {
            if (node1 == node2)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while (node1 != node2) {
            node1 = node1 == null ? pHead1 : node1.next;
            node2 = node2 == null ? pHead2 : node2.next;
        }

        return node1;
    }
}
