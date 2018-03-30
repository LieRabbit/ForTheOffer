/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class 不用加减乘除做加法 {

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2; // 不进位加法
            num2 = (num1 & num2) << 1; // 进位
            num1 = temp;
        }

        return num1;
    }

    public static void main(String[] args) {
        不用加减乘除做加法 test = new 不用加减乘除做加法();
        System.out.println(test.Add(5, 7));
    }
}
