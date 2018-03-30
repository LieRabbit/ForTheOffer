/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.isEmpty())
            return 0;
        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        boolean isPositive = true; // 默认正数
        char first = chars[0];

        // 正负号判断
        if (first == '+')
            left = 1;
        else if (first == '-') {
            left = 1;
            isPositive = false;
        }

        int num = 0;
        int temp = 1;

        while (right >= left) {
            char chNum = chars[right];
            if (!isNum(chNum))
                return 0;
            num += (chNum % '0') * temp;
            temp *= 10;
            right--;
        }

        return isPositive ? num : -num;
    }

    // 是否是数字
    public boolean isNum(char num) {
        return num >= '0' && num <= '9';
    }

    public static void main(String[] args) {
        把字符串转换成整数 test = new 把字符串转换成整数();
        System.out.println(test.StrToInt("-0123"));
    }
}
