package string_t;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/14
 * Time:21:51
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class SwapTrim {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We are happy!");
        System.out.println(replaceSpace(str));
    }

    private static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replace(" ","%20");
        return s;
    }
}
