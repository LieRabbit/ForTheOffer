/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root) != -1;
    }

    public int isBalanced(TreeNode node) {
        if (node == null)
            return 0;
        int left = isBalanced(node.left);
        if (left == -1)
            return -1;
        int right = isBalanced(node.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}
