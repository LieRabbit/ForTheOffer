/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        else {
            int first = getFirstNum(array, k);
            if (first == -1)
                return 0;
            int last = getLastNum(array, k);

            return last - first + 1;
        }
    }

    public int getFirstNum(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        int index = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] < k)
                left = mid + 1;
            else if (array[mid] > k)
                right = mid - 1;
            else {
                index = mid;
                right = mid - 1;
            }
        }

        return index;
    }

    public int getLastNum(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        int index = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] < k)
                left = mid + 1;
            else if (array[mid] > k)
                right = mid - 1;
            else {
                index = mid;
                left = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        数字在排序数组中出现的次数 test = new 数字在排序数组中出现的次数();
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(test.GetNumberOfK(array, 3));
    }
}
