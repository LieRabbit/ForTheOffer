/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class 表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        boolean hasSign = false, hasDecimal = false, hasE = false;
        for (int i = 0, len = str.length; i < len; i++) {
            char ch = str[i];
            if (ch == '+' || ch == '-') {
                if (hasSign && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                else if (!hasSign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                hasSign = true;
            } else if (ch == 'e' || ch == 'E') {
                if (hasE || i == len - 1)
                    return false;
                hasE = true;
            } else if (ch == '.') {
                if (hasE || hasDecimal)
                    return false;
                hasDecimal = true;
            } else if (ch < '0' || ch > '9')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        表示数值的字符串 test = new 表示数值的字符串();
        System.out.println(test.isNumeric("123.45e+6".toCharArray()));
    }
}
