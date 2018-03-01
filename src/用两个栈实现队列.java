import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty())
            stack2.push(stack1.pop());
        int first = stack2.pop();
        while (!stack2.empty())
            stack1.push(stack2.pop());
        return first;
    }

    public static void main(String[] args) {
        用两个栈实现队列 twoStackQueue = new 用两个栈实现队列();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        twoStackQueue.push(3);
        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
        twoStackQueue.push(4);
        System.out.println(twoStackQueue.pop());
        twoStackQueue.push(5);
        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
    }
}
