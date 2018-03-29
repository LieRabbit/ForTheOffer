/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty())
            return str;
        char[] chars = str.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < len; i++) {
            if (i == 0 || chars[i - 1] == ' ')
                l = i;
            if (i == len - 1 || chars[i + 1] == ' ')
                r = i;
            if (l != -1 && r != -1) {
                reverse(chars, l, r);
                l = -1;
                r = -1;
            }
        }
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right)
            swap(chars, left++, right--);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        翻转单词顺序列 test = new 翻转单词顺序列();
        System.out.println(test.ReverseSentence("student. a am I"));
    }
}
