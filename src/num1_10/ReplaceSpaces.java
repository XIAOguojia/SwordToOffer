package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/6
 * Time:16:39
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String str = "We are Happy";
        System.out.println(ReplaceBlank2(str));


    }

    public static String ReplaceBlank2(String str){
        if (str == null || str.length()<=0){
            return null;
        }
        return str.replace(" ","%20");
    }

    public static void ReplaceBlank(char[] chars,int length){
        if (chars==null || length <=0){
            return;
        }
    }
}
