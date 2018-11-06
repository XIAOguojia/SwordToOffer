package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/6
 * Time:11:37
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        FindInPartiallySortedMatrix find = new FindInPartiallySortedMatrix();
        find.Test1();
        find.Test2();
        find.Test3();
        find.Test4();
        find.Test5();
        find.Test6();
        find.Test7();

    }

    /**
     * @param matrix 二维数组
     * @param rows   行数
     * @param cols   列数
     * @param number 想找的整数
     * @return true 输入有效，并且找到了该整数
     * false 输入无效或者没找到该整数
     */
    public static boolean find(int[][] matrix, int rows, int cols, int number) {
        if (matrix == null || rows <= 0 || cols <= 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {

            if (matrix[row][col] == number) {
                System.out.println(row + " " + col + " " + matrix[row][col]);
                return true;
            } else if (matrix[row][col] > number) {
                row--;
            } else {
                col++;
            }

        }
        return false;
    }

    public static void Test(String name, int[][] martix, int rows, int colums, int number, boolean expected) {
        if (name != null && !name.trim().equals("")) {
            System.out.println(name + " begins.");
        }
        boolean result = find(martix, rows, colums, number);
        if (result == expected) {
            System.out.println("PASSED.");
        } else {
            System.out.println("FAILED.");
        }
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数在数组中
    public void Test1() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test1", matrix, 4, 4, 7, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数不在数组中
    public void Test2() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test2", matrix, 4, 4, 5, false);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数是数组中最小的数字
    public void Test3() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test3", matrix, 4, 4, 1, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数是数组中最大的数字
    public void Test4() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test4", matrix, 4, 4, 15, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数比数组中最小的数字还小
    public void Test5() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test5", matrix, 4, 4, 0, false);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数比数组中最大的数字还大
    public void Test6() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test6", matrix, 4, 4, 30, false);
    }

    // 鲁棒性测试，输入空指针
    public void Test7() {
        Test("Test7", null, 0, 0, 16, false);
    }
}
