package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/8
 * Time:19:46
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠
 * 地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public static void main(String[] args) {
        System.out.println(RectCoverNumber(10));
    }

    public static int RectCoverNumber(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        int pre = 1;
        int cur = 2;
        int next = 0;
        for (int i = 3; i <= target; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }
}
