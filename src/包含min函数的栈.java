import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class 包含min函数的栈 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.add(node);
        if (minStack.empty())
            minStack.add(node);
        else if (node <= minStack.peek())
            minStack.add(node);
    }

    public void pop() {
        int value = stack.pop();
        if (value == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
