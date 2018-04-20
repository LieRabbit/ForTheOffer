/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占
 * 据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class 矩阵中的路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 记录位置是否已访问
        boolean[] flags = new boolean[matrix.length];

        // 遍历所有位置
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (hasPathCore(matrix, rows, cols, x, y, str, 0, flags))
                    return true;
            }
        }

        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int x, int y, char[] str, int k, boolean[] flags) {
        // 计算当前坐标
        int index = x * cols + y;

        // 非法判断
        if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[index] != str[k] || flags[index])
            return false;

        // 匹配完成
        if (k == str.length - 1)
            return true;

        // 当前点已访问
        flags[index] = true;
        // 往后寻找
        k++;

        // 按上下左右方向寻找
        if (hasPathCore(matrix, rows, cols, x - 1, y, str, k, flags)
                || hasPathCore(matrix, rows, cols, x + 1, y, str, k, flags)
                || hasPathCore(matrix, rows, cols, x, y - 1, str, k, flags)
                || hasPathCore(matrix, rows, cols, x, y + 1, str, k, flags))
            return true;

        // 未找到还原当前点为未访问
        flags[index] = false;

        // 未找到
        return false;
    }
}
