/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class 数组中逆序对 {

    class Count {
        private int value;

        public Count() {
            value = 0;
        }

        public void increment() {
            value++;
        }
    }

    public int InversePairs(int[] array) {
        Count count = new Count();
        inverse(array, 0, array.length - 1, count);
        return count.value;
    }

    public void inverse(int[] array, int left, int right, Count count) {
        if (left != right) {
            int mid = left + (right - left) / 2;
            inverse(array, left, mid, count);
            inverse(array, mid + 1, right, count);
            inverseCore(array, left, mid, right, count);
        }
    }

    public void inverseCore(int[] arr, int left, int mid, int right, Count count) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (arr[l] > arr[r]) {
                count.value = (count.value + mid - l + 1) % 1000000007; // 核心计算
                temp[index++] = arr[r++];
            } else {
                temp[index++] = arr[l++];
            }
        }
        while (l <= mid)
            temp[index++] = arr[l++];
        while (r <= right)
            temp[index++] = arr[r++];
        for (int i = 0; i < index; i++)
            arr[left + i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 3};
        数组中逆序对 test = new 数组中逆序对();
        int res = test.InversePairs(arr);
        System.out.println(res);
    }
}
