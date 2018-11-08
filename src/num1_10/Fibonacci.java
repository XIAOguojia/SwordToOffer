package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/8
 * Time:17:02
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class Fibonacci {
    public static void main(String[] args) {
        Test(0, 0);
        Test(1, 1);
        Test(2, 1);
        Test(3, 2);
        Test(4, 3);
        Test(5, 5);
        Test(6, 8);
        Test(7, 13);
        Test(8, 21);
        Test(9, 34);
        Test(10, 55);

        Test(40, 102334155);

    }

    /**
     * 递归法 简洁但不够高效
     *
     * @param n
     * @return
     */
    public static long Fibonacci_Solution1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
    }

    /**
     * 迭代法 写法较复杂但高效
     *
     * @param n
     * @return
     */
    public static long Fibonacci_Solution2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        long pre = 1;
        long cur = 1;
        long next = 0;
        for (int i = 3; i <= n; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }

        return next;
    }

    // ====================测试代码====================
    private static void Test(int n, int expected) {
        if (Fibonacci_Solution1(n) == expected) {
            System.out.println("Test for " + n + " in solution1 passed.");
        } else {
            System.out.println("Test for " + n + " in solution1 failed.");
        }

        if (Fibonacci_Solution2(n) == expected) {
            System.out.println("Test for " + n + " in solution2 passed.");
        } else {
            System.out.println("Test for " + n + " in solution2 failed.");
        }
    }

}
