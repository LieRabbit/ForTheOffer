/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                count++;

        int charsLen = str.length() + count * 2;
        char[] chars = new char[charsLen];
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                chars[--charsLen] = '0';
                chars[--charsLen] = '2';
                chars[--charsLen] = '%';
            } else
                chars[--charsLen] = str.charAt(i);
        }

        return new String(chars);
    }
}
