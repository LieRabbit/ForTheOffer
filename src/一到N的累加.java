/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 一到N的累加 {

    public int Sum_Solution(int n) {
        boolean a = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        一到N的累加 test = new 一到N的累加();
        System.out.println(test.Sum_Solution(5));
    }
}
