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
    private String outerName;
    private int age;
    class innerClass{
        private String innerName;
        public innerClass(){
            outerName = "hahah";
            age = 19;
        }

        public void show(){
            System.out.println("Name:"+outerName+"    "+"Age:"+age);
        }
    }
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        OuterClass outerClass = new OuterClass();
        OuterClass.innerClass innerClass1 = outerClass.new innerClass();
        innerClass1.show();
    }

    public void show(){
        innerClass innerClass = new innerClass();
        innerClass.show();
    }
}

class InnerClass implements test{
    @Override
    public void fun(){
        System.out.println("hahahaha");
    }
}
