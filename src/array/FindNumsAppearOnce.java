package array;

import java.util.Scanner;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/13
 * Time:15:41
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字。要求时间复杂度是 O(n)，空间复杂度是 O(1)。
 * 举例说明
 * 例如输入数组｛2, 4, 3, 6, 3, 2, 5 }，因为只有 4 、6 这两个数字只出现一次，其他数字都出现了两次，所以输出 4 和 6 。
 * <p>
 * 解题思路
 * 这两个题目都在强调一个（或两个）数字只出现一次，其他的出现两次。这有什么意义呢？我们想到异或运算的一个性质：任何一个数字异或它自己都等于 0。也就是说， 如果我们从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些成对出现两次的数字全部在异或中抵消了。
 * <p>
 * 想明白怎么解决这个简单问题之后，我们再回到原始的问题，看看能不能运用相同的思路。我们试着把原数组分成两个子数组，使得每个子数组包含一个只出现一次的数字，而其他数字都成对出现两次。如果能够这样拆分成两个数组， 我们就可以按照前面的办法分别找出两个只出现一次的数字了。
 * <p>
 * 我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其他数字都出现了两次，在异或中全部抵消了。由于这两个数字肯定不一样，那么异或的结果肯定不为 0，也就是说在这个结果数字的二进制表示中至少就有一位为 1 。我们在结果数字中找到第一个为 1 的位的位置，记为第 n 位。现在我们以第 n 位是不是 １ 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第 n 位都是 1，而第二个子数组中每个数字的第 n 位都是 0。由于我们分组的标准是数字中的某一位是 1 还是 0 ， 那么出现了两次的数字肯定被分配到同一个子数组。因为两个相同的数字的任意一位都是相同的，我们不可能把两个相同的数字分配到两个子数组中去，于是我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其他数字都出现了两次。我们已经知道如何在数组中找出唯一一个只出现一次数字， 因此到此为止所有的问题都已经解决了。
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 4, 3, 6, 3, 5, 2, 5};
        System.out.println(findAppearOnce(arr)[0] + " " + findAppearOnce(arr)[1]);
    }

    private static int[] findAppearOnce(int[] arr) {
        int length = arr.length;
        if (length <= 3 || arr == null) {
            return null;
        }
        int resultExclusiveOR = 0;
        //先进行一次异或
        for (int i = 0; i < arr.length; i++) {
            resultExclusiveOR ^= arr[i];
        }
        //找到异或后的结果的二进制数第一个1的位置，1说明这两个数在这一位有所不同，
        // 可以依据这个来对数组分组，改位为1是一组，为0是另外一组，然后再次进行异或找到这两个不重复的数字
        int indexOf1 = findFirstBit1(resultExclusiveOR);
        int[] result = {0, 0};
        //再次异或，根据第n位是否为1对数组进行划分
        for (int i = 0; i < length; i++) {
            if (isBit1(arr[i], indexOf1)) {
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }

        return result;
    }

    private static boolean isBit1(int num, int indexOf1) {
        num >>= indexOf1;
        return (num & 1) == 1;
    }

    private static int findFirstBit1(int resultExclusiveOR) {
        int indexBit = 0;
        while ((resultExclusiveOR & 1) == 0 && indexBit < 32) {
            resultExclusiveOR >>= 1;
            ++indexBit;
        }
        return indexBit;

    }
}
