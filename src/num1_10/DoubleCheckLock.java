package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/5
 * Time:10:39
 * 单例的双重检查
 * 这里的synchronized已经保证了INSTANCE写操作对其它线程读操作的可见性。
 * 使用volatile关键字的目的不是保证可见性（synchronized已经保证了可见性），而是为了保证
 * 顺序性。具体来说，INSTANCE = new Singleton()不是原子操作，实际上被拆分为了三步：1)
 * 分配内存；2) 初始化对象；3) 将INSTANCE指向分配的对象内存地址。 如果没有volatile，可能
 * 会发生指令重排，使得INSTANCE先指向内存地址，而对象尚未初始化，其它线程直接使用
 * INSTANCE引用进行对象操作时出错。详细原理可参见《双重检查锁定与延迟初始化》
 */
public class DoubleCheckLock {
    private static volatile DoubleCheckLock INSTANCE = null;

    private DoubleCheckLock() {
    }

    public static DoubleCheckLock getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLock.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }
}
