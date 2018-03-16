import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class 最小的k个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (input == null || k < 0 || k > input.length)
            return res;

        // 建立大根堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(input, i, k);
        }

        // 依次与堆顶对比
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                swap(input, 0, i);
                adjustHeap(input, 0, k);
            }
        }

        for (int i = 0; i < k; i++)
            res.add(input[i]);

        return res;
    }

    public void adjustHeap(int[] heap, int index, int length) {
        int node = heap[index];

        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && heap[i + 1] > heap[i])
                i++;
            if (node < heap[i]) {
                heap[index] = heap[i];
                index = i;
            } else
                break;
        }
        heap[index] = node;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        最小的k个数 test = new 最小的k个数();
        List<Integer> res = test.GetLeastNumbers_Solution(arr, 4);
        for (Integer a : res)
            System.out.print(a + " ");
    }

}
