/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围 {

    public int movingCount(int threshold, int rows, int cols) {
        // 记录访问过的点
        boolean[][] isVisit = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0, isVisit);
    }

    public int movingCountCore(int threshold, int rows, int cols, int y, int x, boolean[][] isVisit) {
        // 排除非法点以及访问过的点
        if (y >= rows || y < 0 || x >= cols || x < 0 || isVisit[y][x] || calcXY(x, y) > threshold)
            return 0;

        // 设置当前点已访问
        isVisit[y][x] = true;

        // 按上下左右方向访问
        return movingCountCore(threshold, rows, cols, y + 1, x, isVisit)
                + movingCountCore(threshold, rows, cols, y - 1, x, isVisit)
                + movingCountCore(threshold, rows, cols, y, x - 1, isVisit)
                + movingCountCore(threshold, rows, cols, y, x + 1, isVisit)
                + 1;
    }

    // 计算坐标为（x，y）的点的数位之和
    private int calcXY(int x, int y) {
        return calc(x) + calc(y);
    }

    // 计算value的数位之和
    private int calc(int value) {
        int res = 0;

        while (value != 0) {
            res += value % 10;
            value /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        机器人的运动范围 test = new 机器人的运动范围();
        System.out.println(test.movingCount(15, 20, 20));
    }
}
