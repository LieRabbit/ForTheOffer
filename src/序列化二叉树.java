/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class 序列化二叉树 {
    int index;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        SerializeCore(root, sb);

        return sb.toString();
    }

    void SerializeCore(TreeNode node, StringBuilder sb) {
        if (node == null)
            sb.append("#!");
        else {
            sb.append(node.val).append("!");
            SerializeCore(node.left, sb);
            SerializeCore(node.right, sb);
        }
    }

    TreeNode Deserialize(String str) {
        index = -1;
        return DeserializeCore(str.split("!"));
    }

    TreeNode DeserializeCore(String[] strs) {
        index++;
        if (index > strs.length)
            return null;
        String str = strs[index];
        if (str.equals("#"))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = DeserializeCore(strs);
            node.right = DeserializeCore(strs);
            return node;
        }
    }
}
