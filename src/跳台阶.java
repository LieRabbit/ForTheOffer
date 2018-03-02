/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else {
            int prePre = 1;
            int pre = 2;
            int result = 0;

            for (int i = 3; i <= target; i++) {
                result = pre + prePre;
                prePre = pre;
                pre = result;
            }

            return result;
        }
    }
}
