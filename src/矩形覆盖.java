/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else {
            int prePre = 1;
            int pre = 2;
            int res = 0;
            for (int i = 3; i <= target; i++) {
                res = pre + prePre;
                prePre = pre;
                pre = res;
            }

            return res;
        }
    }
}
