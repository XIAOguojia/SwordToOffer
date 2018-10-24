package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/10/18
 * Time:20:16
 */
class person{
    void work(){
        System.out.println("工作");
    }
}

class Teacher extends person{

    @Override
    void work() {
        System.out.println("教学生");
    }
}

class Student extends person{

    @Override
    void work() {
        System.out.println("学习");
    }
}

public class ManyObjectsTest {
    public static void main(String[] args) {
//        person p = new person();
//        Teacher t = new Teacher();
//        Student s = new Student();
//
//        if (t instanceof person){
//            s = (Student)t;
//        }
        boolean b = true;
        String s;
        int a = 1;
        s = "1"+ b;
        System.out.println(s);

        String s1 = null;
        s1.concat("abc");
        System.out.println(s1);
    }
}
