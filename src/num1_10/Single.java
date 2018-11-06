package num1_10;

/**
 * 实现单例模式
 * 一共有九种实现方式
 */
public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}
