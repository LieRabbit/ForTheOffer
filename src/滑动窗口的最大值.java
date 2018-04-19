import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();

        if (size < 1)
            return res;

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i])
                queue.pollLast();
            queue.add(i);

            if (i >= size - 1) {
                // 判断最大值是否在窗口内
                if (queue.peekFirst() == i - size)
                    queue.pollFirst();
                res.add(num[queue.peekFirst()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        滑动窗口的最大值 test = new 滑动窗口的最大值();
        int[] arr = {10, 14, 12, 11};
        test.maxInWindows(arr, 0);
    }
}
