/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int k1 = 0;
        int k2 = 0;
        for (int a : array)
            k1 ^= a; // 最后k1为两数字的异或结果
        int rightOne = k1 & (~k1 + 1); // 二进制右边第一个1
        for (int a : array)
            if ((a & rightOne) != 0)
                k2 ^= a; // 最后k2为其中一个数字
        num1[0] = k2;
        num2[0] = k1 ^ k2;
    }
}
