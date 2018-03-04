/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return;

        int count = 0; // 记录奇数出现次数
        for (int a : array)
            if (a % 2 == 1)
                count++;

        int[] temp = new int[array.length]; // 新建数组装入奇数和偶数
        int pre = 0; // 从头开始
        int back = count; // 从最后一个奇数后面开始
        for (int a : array)
            if (a % 2 == 0)
                temp[back++] = a;
            else
                temp[pre++] = a;

        System.arraycopy(temp, 0, array, 0, array.length); // 复制temp到array
    }
}
