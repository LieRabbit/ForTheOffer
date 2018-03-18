import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉树搜索与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode head = null;

        while (cur != null || !stack.empty()) {
            if (cur == null) {
                TreeNode node = stack.pop();
                if (head == null)
                    head = node;
                if (pre != null) {
                    pre.right = node;
                    node.left = pre;
                }
                pre = node;
                cur = node.right;
            } else {
                stack.add(cur);
                cur = cur.left;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(12);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(18);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(15);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;

        二叉树搜索与双向链表 test = new 二叉树搜索与双向链表();
        test.Convert(n1);
    }
}
