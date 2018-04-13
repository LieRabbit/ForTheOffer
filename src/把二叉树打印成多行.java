import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        ArrayList<Integer> row = new ArrayList<>();
        TreeNode last = pRoot;
        TreeNode nLast = null;
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

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
                res.add(row);
                row = new ArrayList<>();
                last = nLast;
            }
        }

        return res;
    }
}
