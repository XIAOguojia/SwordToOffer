package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/8
 * Time:19:35
 */
public class JumpFloorII {
    public static void main(String[] args) {
        System.out.println(JumpNumII(4));
    }

    public static int JumpNumII(int target) {
        return (int) Math.pow(2,target-1);
    }
}
