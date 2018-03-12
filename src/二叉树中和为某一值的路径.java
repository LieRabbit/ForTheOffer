import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return allList;

        target -= root.val;
        list.add(root.val);

        if (target == 0 && root.left == null && root.right == null)
            allList.add(new ArrayList<>(list));

        FindPath(root.left, target);
        FindPath(root.right, target);

        list.remove(list.size() - 1); // 弹出最后一个数

        return allList;
    }

    public static void main(String[] args) {
        二叉树中和为某一值的路径 test = new 二叉树中和为某一值的路径();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        ArrayList<ArrayList<Integer>> res = test.FindPath(node1, 22);

        for (ArrayList<Integer> row : res) {
            for (Integer value : row)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}
