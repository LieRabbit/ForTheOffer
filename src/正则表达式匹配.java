/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class 正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;

        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        // pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;
        // 模式后一个字符是*，且字符串第1个跟模式第1个匹配,分2种匹配模式。如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length))
                return matchCore(str, strIndex + 1, pattern, patternIndex) // x*匹配1个字符，再匹配str中的下一个
                        || matchCore(str, strIndex, pattern, patternIndex + 2); // 模式后移2位，视为x*匹配0个字符
            else
                return matchCore(str, strIndex, pattern, patternIndex + 2);
        } else {
            // 模式后一个字符不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length))
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            else
                return false;
        }
    }
}
