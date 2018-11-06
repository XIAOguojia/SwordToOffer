package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/5
 * Time:15:36
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为
 * 7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class DuplicationInArray {
    int data;

    public static void main(String[] args) {
        DuplicationInArray d = new DuplicationInArray();
        d.test1();
        d.test2();
        d.test3();
        d.test4();
        d.test5();
        d.test6();

    }

    /**
     * 参数：
     *
     * @param numbers 一个整数数组
     * @param length  数组的长度
     * @return true  - 输入有效，并且数组中存在重复的数字
     * false - 输入无效，或者数组中没有重复的数字
     */
    public boolean duplicate(int[] numbers, int length,DuplicationInArray duplicaton) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplicaton.data = numbers[i];
                    System.out.println(numbers[i]);
                    return true;
                }

                //swap
                int temp=numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] =  temp;
            }
        }
        return false;
    }

    // ====================测试代码====================
    public boolean contains(int[] array,int length, int number)
    {
        for(int i = 0; i < length; ++i)
        {
            if(array[i] == number) {
                return true;
            }
        }
        return false;
    }

    public void test(String name,int[] numbers,int lengthNumbers,int[] expected,int expectedExpected,boolean validArgument){
        System.out.println(name+" begins");
        DuplicationInArray duplication = new DuplicationInArray();
        boolean validInput = duplicate(numbers,lengthNumbers,duplication);
        if (validArgument == validInput){
            if (validArgument){
                if (contains(expected,expectedExpected,duplication.data)){
                    System.out.println("Passed");
                }else{
                    System.out.println("FAILED");
                }
            }else {
                System.out.println("Passed");
            }
        }else {
            System.out.println("FAILED");
        }
    }

    // 重复的数字是数组中最小的数字
    public void test1()
    {
        int[] numbers = { 2, 1, 3, 1, 4 };
        int[] duplications = { 1 };
        test("Test1", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 重复的数字是数组中最大的数字
    public void test2()
    {
        int[] numbers = { 2, 4, 3, 1, 4 };
        int[] duplications = { 4 };
        test("Test2", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 数组中存在多个重复的数字
    public void test3()
    {
        int[] numbers = { 2, 4, 2, 1, 4 };
        int[] duplications = { 2,4 };
        test("Test3", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 没有重复的数字
    public void test4()
    {
        int[] numbers = {  2, 1, 3, 0, 4 };
        // not in use in the test function
        int[] duplications = { -1 };
        test("Test4", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 没有重复的数字
    public void test5()
    {
        int[] numbers = {  2, 1, 3, 5, 4 };
        // not in use in the test function
        int[] duplications = { -1 };
        test("Test5", numbers, numbers.length, duplications, duplications.length, true);
    }

    // 无效的输入
    public void test6()
    {
        int[] numbers = null;
        // not in use in the test function
        int[] duplications = { -1 };
        test("Test6", numbers, 0, duplications, duplications.length, true);
    }
}
