package array;

import java.util.Arrays;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/30
 * Time:12:57
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplication = new int[1];

        //duplicate1( numbers,length,duplication);
        //duplicate2(numbers,length,duplication);
        duplicate3(numbers, length, duplication);

    }

    /***
     * 注意到数组的大小为n，数组范围为0到n-1，所以说，如果没有重复数字的话，那么刚好每个下标对应
     * 的就是自己的数字，例如numbers[2] = 2;我们可以通过检查，发现下标和数组不相等则交换到对应的下标中，
     * 如果已经是放的对应下标的数字，则说明是重复的数字
     * 时间复杂度O(N),不需要额外内存
     */
    private static boolean duplicate3(int[] numbers, int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }

        // 判断数组是否合法（每个数都在0~n-1之间）
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    System.out.println(duplication[0]);
                    return true;
                }

                int tmp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }

    /**
     * 用一个跟原先数组大小一样的辅助数组，先把辅助数组全部置零，然后检测到对应的数字时，辅助数组该位置的值加1
     * 例如：第一个数是2 ，则tmp[2]的值从0变为1
     * 时间复杂度O(N),额外内存为n
     */
    private static boolean duplicate2(int[] numbers, int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }
        int[] tmp = new int[length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }
        for (int i = 0; i < length; i++) {
            tmp[numbers[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (tmp[i] >= 2) {
                duplication[0] = i;
                System.out.println(duplication[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 解法一：
     * 先将数组排好序，然后检测当前值与下一个值是否重复
     * 时间复杂度n(logn),不太好
     */
    private static boolean duplicate1(int[] numbers, int length, int[] duplication) {
        if (numbers == null) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                System.out.println(duplication[0]);
                return true;
            }
        }
        return false;
    }
}
