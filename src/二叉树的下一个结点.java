/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) // 二叉树为空，则返回空
            return null;
        else if (pNode.right != null) { // 节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else { // 如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
            while (pNode.next != null) {
                if (pNode.next.left == pNode)
                    return pNode.next;
                pNode = pNode.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        二叉树的下一个结点 test = new 二叉树的下一个结点();
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        t1.left = t2;
        t2.next = t1;
        t2.right = t3;
        t3.next = t2;
        System.out.println(test.GetNext(t3));
    }
}
