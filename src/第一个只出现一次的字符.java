/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        int[] map = new int[256];
        for (int i = 0; i < len; i++) {
            map[str.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (map[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        第一个只出现一次的字符 test = new 第一个只出现一次的字符();

    }
}
