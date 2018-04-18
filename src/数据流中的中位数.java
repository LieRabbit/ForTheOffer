import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class 数据流中的中位数 {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);

    public void Insert(Integer num) {
        if ((count++ & 1) == 0) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 0)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return Double.valueOf(maxHeap.peek());
    }
}
