package array;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/31
 * Time:23:03
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字,但不能修改输入数组
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class FindRepeatNumber2 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;

        System.out.println(getDuplication(numbers, length));
    }

    private static int getDuplication(int[] numbers, int length) {
        if (numbers == null || length < 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int length, int start, int middle) {
        if (numbers == null) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= middle) {
                count++;
            }
        }
        return count;
    }
}
