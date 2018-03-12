class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        RandomListNode cur = pHead;
        RandomListNode newNode;
        while (cur != null) { // 在链表每个元素后面添加一个克隆元素
            newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = pHead;
        while (cur != null) { // 给每个克隆元素设置随机指针
            newNode = cur.next;
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode next;
        while (cur != null) { // 分割出克隆链表，还原原链表
            next = cur.next.next;
            newNode = cur.next;
            newNode.next = next == null ? null : next.next;
            cur.next = next;
            cur = next;
        }

        return newHead;
    }
}
