package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/10
 * Time:20:16
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("sometest.AA");
        System.out.println("BBBB");
        Class.forName("sometest.AA");
    }
}

class AA{
    static {
        System.out.println("A");
    }
}
