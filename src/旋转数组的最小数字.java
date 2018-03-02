/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (left + 1 == right) // 只剩2个数时直接比较其大小
                break;
            else if (array[left] < array[right]) // 当局部列表有序返回头
                return array[left];
            else if (array[left] > array[mid]) // 当局部列表头元素大于中间元素，这里有循环，也就是有最小值，搜索左边
                right = mid;
            else if (array[mid] > array[right]) // 当局部列表中间元素大于尾元素，这里有循环，也就是有最小值，搜索右边
                left = mid;
            else {
                // 当局部列表头元素等于中间元素等于尾元素，遍历寻找最小值
                while (left < right) {
                    if (array[left] == array[mid])
                        left++;
                    else if (array[left] < array[mid])
                        return array[left];
                    else {
                        right = mid;
                        break;
                    }
                }
            }
        }

        return Math.min(array[left], array[right]);
    }


    public static void main(String[] args) {
        旋转数组的最小数字 xuan = new 旋转数组的最小数字();
        int[] arr = {3, 4, 5, 6, 1, 2};
        int res = xuan.minNumberInRotateArray(arr);
        System.out.println(res);
    }
}
