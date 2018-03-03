/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class 数组的整数次方 {
    public double Power(double base, int exponent) {
        double result = 1;
        double temp = base;
        boolean isNegative;

        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        } else
            isNegative = false;

        while (exponent != 0) {
            System.out.print(temp + " ");
            if ((exponent & 1) == 1)
                result *= temp;
            temp *= temp;
            exponent >>= 1;
        }

        return isNegative ? 1 / result : result;
    }

    public double Power2(double base, int exponent) {
        double result = 1;

        for (int i = 0; i < exponent; i++) {
            System.out.print(result + " ");
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        数组的整数次方 test = new 数组的整数次方();
        System.out.println(test.Power(2, 10));
        System.out.println(test.Power2(2, 10));
    }
}
