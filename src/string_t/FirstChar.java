package string_t;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/5
 * Time:15:48
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstChar {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
        String s = "abaccdeff";
        System.out.println(findTheFirstChar(s));
    }

    /**
     * 剑指offer的算法，算法复杂度O(N)
     * @param s
     * @return
     */
    private static char findTheNotRepeatingFirstChar(String s) {
        //判断字符串长度是否为0
        if (s.length() == 0) {
            return '\0';
        }
        //把字符串变成char数组
        char[] tmpArr = s.toCharArray();
        //char为8位，最多256种字符
        int[] table = new int[256];
        //初始化置0
        for (int i = 0; i < table.length ; i++) {
            table[i] = 0;
        }
        //出现该字符则在对应的位置加1
        for (int i = 0; i < tmpArr.length; i++) {
            table[(int) tmpArr[i]]++;
        }
        //再次遍历，查找第一个等于1的
        for (int i = 0; i < tmpArr.length; i++) {
            if (table[(int) tmpArr[i]] == 1 ){
                return tmpArr[i];
            }
        }
        return '\0';
    }

    /**
     * 自己写的，利用map存储，键为字符，值为Integer
     * 算法复杂度O(N)
     * @param s
     * @return
     */
    private static char findTheFirstChar(String s) {
        //判断字符串长度是否为0
        if (s.length() == 0) {
            return '\0';
        }
        Map<Character,Integer> map = new TreeMap<>();
        char[] tmpArr = s.toCharArray();


        for (int i = 0; i < tmpArr.length; i++) {
//判断是否已经存在这个键了，不存在则新添加，设值为1，存在则在原有基础上+1
            if (map.get(tmpArr[i]) == null){
                map.put(tmpArr[i],1);
            }else {
                Integer integer = map.get(tmpArr[i]);
                map.put(tmpArr[i],++integer);
            }
        }
        //再次遍历char数组，找到map中第一个值为1的
        for (int i = 0; i < tmpArr.length; i++) {
            if (map.get(tmpArr[i])==1){
                return tmpArr[i];
            }
        }
        return '\0';
    }
}
