/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class 二叉搜索树的第k个结点 {
    int index;

    TreeNode KthNode(TreeNode pRoot, int k) {
        index = k;
        return KthNodeCore(pRoot);
    }

    TreeNode KthNodeCore(TreeNode pRoot) {
        if (pRoot == null)
            return pRoot;
        TreeNode node = KthNodeCore(pRoot.left);
        if (node != null)
            return node;
        index--;
        if (index == 0)
            return pRoot;
        node = KthNodeCore(pRoot.right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t5.left = t3;
        t5.right = t7;

        t3.left = t2;
        t3.right = t4;

        t7.left = t6;
        t7.right = t8;

        二叉搜索树的第k个结点 test = new 二叉搜索树的第k个结点();
        System.out.println(test.KthNode(t5,3).val);
    }
}
