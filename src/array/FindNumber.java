package array;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/6
 * Time:21:27
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumber {
    public static void main(String[] args) {
        int target = 7;
        int[][] array = new int[][]{{1, 2, 8, 9},
                {4, 7, 10, 13},
        };
        System.out.println(Find3(target, array));
    }

    /**
     *
     * */
    private static boolean Find3(int target, int[][] array) {
        return false;
    }

    /**
     * 通过对角线的方法查找，由于是从左到右递增以及从上到下递增，所以：
     * 1、当对角线的值小于target时，必然其左边和右边的值都会小于target；
     * 2、target=对角线的值时，刚好找到，return true；
     * 3、target>对角线的值时，往其左方和下方查找是否有值等于target，若没有，return false；有，return true；
     */
    private static boolean Find2(int target, int[][] array) {
        //i,j分别表示行数和列数
        for (int i = 0, j = 0; i < array.length && j < array[0].length; i++, j++) {
            System.out.println(array[i][j]);
            if (array[i][j] < target) {
                continue;
            } else if (array[i][j] > target) {
                for (int x = i; x >= 0; x--) {
                    if (target == array[x][j]) {
                        return true;
                    }
                }
                for (int y = j; y >= 0; y--) {
                    if (target == array[i][y]) {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 通过遍历二维数组，来找出是否有对应的值，太傻！！！(但是这却是最容易想到的方法，摊手.jpg)
     */
    private static boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }


}
