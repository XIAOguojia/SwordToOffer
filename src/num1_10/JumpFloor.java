package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/8
 * Time:19:30
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多
 * 少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(JumpNumber(4));
    }

    public static int JumpNumber(int target) {
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
