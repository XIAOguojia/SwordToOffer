package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/21
 * Time:20:49
 * 测试System.exit(0)和return对finally语句的影响
 *
 *
 * 结果：在catch语句块中调用System.exit(0)return,finally语句块不执行
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(Mytest());
//        try {
//            int i = 10/0;
//            System.out.println("Try");
//            }catch (Exception e){
//            System.exit(0);
//            System.out.println("catch");
//            e.printStackTrace();
//        }finally {
//            System.out.println("finally");
//        }
    }

    private static int Mytest() {
        int i= 0;
        try {
            i++;
            throw new Exception("llll");
        } catch (Exception e) {
            return i++;
        }finally {
            i++;
        }
    }
}
