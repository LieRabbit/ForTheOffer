/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;
        int m2 = 0, m3 = 0, m5 = 0;
        int[] arr = new int[index];
        arr[0] = 1;
        for (int i = 1; i < index; i++) {
            arr[i] = Math.min(arr[m2] * 2, Math.min(arr[m3] * 3, arr[m5] * 5));
            if (arr[i] == arr[m2] * 2)
                m2++;
            if (arr[i] == arr[m3] * 3)
                m3++;
            if (arr[i] == arr[m5] * 5)
                m5++;
        }

        return arr[index - 1];
    }
}
