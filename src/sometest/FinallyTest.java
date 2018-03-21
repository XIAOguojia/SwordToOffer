package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/21
 * Time:20:49
 * 测试System.exit(0)对finally语句的影响
 *
 *
 * 结果：在catch语句块中调用System.exit(0),finally语句块不执行
 */
public class FinallyTest {
    public static void main(String[] args) {
        try {
            int i = 10/0;
            System.out.println("Try");
            }catch (Exception e){
            System.exit(0);
            System.out.println("catch");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
