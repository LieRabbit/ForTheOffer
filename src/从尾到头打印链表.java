import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        printListFromTailToHead(listNode, res);

        return res;
    }

    public void printListFromTailToHead(ListNode node, List<Integer> res) {
        if (node != null) {
            printListFromTailToHead(node.next, res);
            res.add(node.val);
        }
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode node = listNode;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        while (!stack.empty()) {
            node = stack.pop();
            res.add(node.val);
        }

        return res;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        ListNode node = reverseList(listNode);

        while (node != null) {
            res.add(node.val);
            node = node.next;
        }

        return res;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
