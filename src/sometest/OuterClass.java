package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/8
 * Time:20:30
 */
interface test{
    public void fun();
}


public class OuterClass {
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
    }
}

class InnerClass implements test{
    @Override
    public void fun(){
        System.out.println("hahahaha");
    }
}
