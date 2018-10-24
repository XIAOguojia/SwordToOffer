package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/10/24
 * Time:10:06
 * tryfinally测试
 */
public class TryFinally {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("1");
        }finally {
            try {
                throw new RuntimeException("2");
            }finally {
                throw new RuntimeException("3");
            }
        }
    }
}
