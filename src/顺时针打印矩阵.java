import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null)
            return res;
        int row = matrix.length;
        if (row == 0)
            return res;
        int col = matrix[0].length;
        if (col == 0)
            return res;

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        while (top <= bottom && left <= right) {
            // 从左往右
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            // 从上到下
            for (int i = top + 1; i <= bottom; i++)
                res.add(matrix[i][right]);

            // 从右往左，当top==bottom时和从左往右重复了
            for (int i = right - 1; i >= left && top != bottom; i--)
                res.add(matrix[bottom][i]);

            // 从下到上，当right==left时和从上到下重复了
            for (int i = bottom - 1; i > top && right != left; i--)
                res.add(matrix[i][left]);
            top++;
            left++;
            right--;
            bottom--;
        }

        return res;
    }
}
