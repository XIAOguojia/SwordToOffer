package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/7/26
 * Time:22:26
 */
public class ValueReferenceTest {
    public static void main(String[] args) {
        int num = 10;
        String str = "Hello";
        foo1(num);
        System.out.println(num);

        foo2(str);
        System.out.println(str);

        StringBuilder stringBuilder = new StringBuilder("iphone");
        foo3(stringBuilder);
        System.out.println(stringBuilder);

        StringBuilder sb = new StringBuilder("ipad");
        foo4(sb);
        System.out.println(sb);
    }

    /**
     * 提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符。
     * sb 没有被改变，还是 "ipad"。
     */
    private static void foo4(StringBuilder sb) {
        sb = new StringBuilder("hahahaha");
    }

    //提供了改变自身方法的引用类型,sb 被改变了，变成了"iphoneX"。
    private static void foo3(StringBuilder stringBuilder) {
        stringBuilder.append("X");
    }

    //没有提供改变自身方法的引用类型,str 也没有被改变
    private static void foo2(String  value) {
        value = "aaa";
    }

    // num 没有被改变
    private static void foo1(int value) {
        value = 100;
    }


}
