/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }


    public static void main(String[] args) {
        变态跳台阶 jump = new 变态跳台阶();
        System.out.println(jump.JumpFloorII(6));
    }
}
