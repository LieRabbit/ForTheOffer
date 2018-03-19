/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        int length = array.length;
        int count = 1;
        int res = array[0];

        for (int i = 1; i < length; i++) {
            if (count == 0) {
                res = array[i];
                count = 1;
            } else {
                if (res == array[i])
                    count++;
                else
                    count--;
            }
        }

        count = 0;
        for (int a : array)
            if (res == a)
                count++;

        return count > length / 2 ? res : 0;
    }
}
