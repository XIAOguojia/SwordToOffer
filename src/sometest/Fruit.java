package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/8
 * Time:22:22
 */
public class Fruit {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        try{
            fruits[0] = new Apple();
        }catch (Exception e){
            System.out.println("can't input a apple");
        }
        try{
            fruits[1] = new A();
        }catch (Exception e){
            System.out.println("can't input a A");
        }
        try{
            fruits[2] = new Orange();
        }catch (Exception e){
            System.out.println("can't input a Orange");
        }
    }
}

class Apple extends Fruit{

}

class A extends  Apple{

}
class Orange extends  Fruit{

}