package num11_20;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/12/25
 * Time:15:07
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class MinNumberInRotatedArray {

    public static void main(String[] args) {
        MinNumberInRotatedArray number = new MinNumberInRotatedArray();
        // 典型输入，单调升序的数组的一个旋转
        int array1[] = { 3, 4, 5, 1, 2 };
        number.Test(array1, array1.length, 1);

        // 有重复数字，并且重复的数字刚好的最小的数字
        int array2[] = { 3, 4, 5, 1, 1, 2 };
        number.Test(array2, array2.length, 1);

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int array3[] = { 3, 4, 5, 1, 2, 2 };
        number.Test(array3, array3.length, 1);

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int array4[] = { 1, 0, 1, 1, 1 };
        number.Test(array4, array4.length, 0);

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int array5[] = { 1, 2, 3, 4, 5 };
        number.Test(array5, array5.length, 1);

        // 数组中只有一个数字
        int array6[] = { 2 };
        number.Test(array6, array6.length, 2);

        // 输入nullptr
        number.Test(null, 0, 0);
    }

    /**
     * 由于旋转数组可以看做两个升序的子数组，可以使用二分法
     * @param array
     * @param length
     * @return
     */
    public int Min(int[] array, int length) {
        if (array == null || length <= 0) {
            throw new IllegalArgumentException("数组为空或者长度过小");
        }
        int index1 = 0;
        int index2 = length - 1;
        int middle = index1;
        while (array[index1] >= array[index2]) {
            // 如果index1和index2指向相邻的两个数，
            // 则index1指向第一个递增子数组的最后一个数字，
            // index2指向第二个子数组的第一个数字，也就是数组中的最小数字
            if (index2 - index1 == 1) {
                middle = index2;
                break;
            }

            // 如果下标为index1、index2和indexMid指向的三个数字相等，
            // 则只能顺序查找
            middle = (index1 + index2) >> 1;
            if (array[index1]==array[index2]&&array[index1]==array[middle]){
                return MinInOrder(array,index1,index2);
            }
            // 缩小查找范围
            if (array[middle] > array[index1]) {
                index1 = middle;
            }
            if (array[middle] < array[index2]) {
                index2 = middle;
            }
        }
        return array[middle];
    }

    public int MinInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1+1; i <= index2; i++) {
            if (result > array[i]){
                result = array[i];
            }
        }
        return result;
    }

    private void Test(int[] numbers, int length, int expected) {
        int result = 0;
        try
        {
            result = Min(numbers, length);

            for (int i = 0; i < length; ++i) {
                System.out.print(numbers[i]+" ");
            }

            if (result == expected) {
                System.out.println("\tpassed\n");
            } else {
                System.out.println("\tfailed\n");
            }
        }catch (Exception e){
            if(numbers == null) {
                System.out.println("Test passed.\n");
            }else {
                System.out.println("Test failed.\n");
            }
        }

    }
}
