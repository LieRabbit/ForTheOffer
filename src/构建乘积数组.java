/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        if (A == null)
            return null;
        int length = A.length;
        int[] B = new int[length];
        if (length == 0)
            return B;
        B[0] = 1;
        // 计算下三角
        for (int i = 1; i < length; i++)
            B[i] = B[i - 1] * A[i - 1];

        // 计算上三角
        int temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }
}
