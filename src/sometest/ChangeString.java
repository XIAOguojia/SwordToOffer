package sometest;

import java.lang.reflect.Field;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/7/25
 * Time:20:45
 * 通过反射改变String类的值
 */
public class ChangeString {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "abcd";
        System.out.println("s = " + s);
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(s);
        value[3] = 'z';
        System.out.println("s = " + s);

        valueField.set(s,new char[]{'1','2','3'});
        System.out.println("s = " + s);
        System.out.println("s.length = " + s.length());
    }
}
