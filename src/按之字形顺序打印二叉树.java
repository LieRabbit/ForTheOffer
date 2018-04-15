import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        ArrayList<Integer> row = new ArrayList<>();
        TreeNode last = pRoot;
        TreeNode node, nLast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean isNeedReverse = false; // 是否需要反转

        while (!queue.isEmpty()) {
            node = queue.poll();
            row.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nLast = node.left;
            }

            if (node.right != null) {
                queue.add(node.right);
                nLast = node.right;
            }

            if (node == last) {
                last = nLast;
                if (isNeedReverse)
                    Collections.reverse(row);
                res.add(row);
                row = new ArrayList<>();
                isNeedReverse = !isNeedReverse;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        按之字形顺序打印二叉树 test = new 按之字形顺序打印二叉树();

        ArrayList<ArrayList<Integer>> res = test.Print(t1);

        for (ArrayList<Integer> row : res) {
            for (Integer value : row)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}
