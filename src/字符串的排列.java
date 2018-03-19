import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        HashSet<String> set = new HashSet<>();
        permutation(str.toCharArray(), 0, set);
        res.addAll(set);
        Collections.sort(res);

        return res;
    }

    public void permutation(char[] chars, int index, HashSet<String> set) {
        int length = chars.length;
        if (index == length - 1) {
            set.add(String.valueOf(chars));
        } else {
            for (int i = index; i < length; i++) {
                swap(chars, i, index);
                permutation(chars, index + 1, set);
                swap(chars, i, index);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        字符串的排列 test = new 字符串的排列();
        List<String> res = test.Permutation("aabc");
        for (String str : res)
            System.out.println(str);
    }
}
