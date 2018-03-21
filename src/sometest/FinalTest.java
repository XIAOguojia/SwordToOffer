package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/21
 * Time:20:55
 * 测试final对引用变量的影响
 *
 * 结果：使用 final 关键字修饰一个变量时，引用变量不能变，引用变量所指向的对象中的内容还是可以改变的。
 */
public class FinalTest {
    public static void main(String[] args) {
        final String s1 = "aaa";
        System.out.println(s1);
//        s1 = "bb";
        final People p1 = new People("zhangsan","20");
        System.out.println(p1);
        p1.setName("Jia");
        p1.setAge("38");
        System.out.println(p1);
    }

}
