/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            int prePre = 1; // n - 2
            int pre = 1; // n - 1
            int result = 0; // n

            for (int i = 3; i <= n; i++) {
                result = prePre + pre;
                prePre = pre;
                pre = result;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        斐波那契数列 test = new 斐波那契数列();
        System.out.println(test.Fibonacci(3));
    }
}
