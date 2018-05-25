package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/5/24
 * Time:13:29
 */
public class thisTest {
    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}

class Parent {
    private Parent mSelf;
    Parent(){
        mSelf = this;
    }
    public void show() {
        System.out.println(this.getClass().getName()+"3");
        System.out.println(super.getClass().getName()+"4");
        System.out.println(mSelf.getClass().getName()+"5");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println(this.getClass().getName()+"1");
        System.out.println(super.getClass().getName()+"2");
        super.show();
    }
}
