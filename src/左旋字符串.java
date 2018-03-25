/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class 左旋字符串 {
    public String LeftRotateString(String str, int k) {
        if(str == null)
            return null;
        int len = str.length();
        if(len == 0)
            return "";
        k %= len;

        return str.substring(k, len) + str.substring(0, k);
    }

    public static void main(String[] args) {
        左旋字符串 test = new 左旋字符串();
        System.out.println(test.LeftRotateString("abcXYZdef",3));
    }
}
