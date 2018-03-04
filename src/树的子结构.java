/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        // 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1 != null && root2 != null) {
            // 如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val)
                // 以这个根节点为起点判断是否包含Tree2
                res = isSubTree(root1, root2);
            // 如果找不到，那么就把root1的左孩子当作起点，去判断是否包含Tree2
            if (!res)
                res = HasSubtree(root1.left, root2);
            // 如果还找不到，那么就再去root1的右孩子当作起点，去判断是否包含Tree2
            if (!res)
                res = HasSubtree(root1.right, root2);
        }

        return res;
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        // 如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null)
            return true;
        // 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        else if (node1 == null)
            return false;
        // 如果其中有一个点没有对应上，返回false
        else if (node1.val != node2.val)
            return false;
        // 如果根节点对应的上，那么就分别去子节点里面匹配
        else
            return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }

}
