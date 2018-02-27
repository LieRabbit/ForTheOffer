import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
}
