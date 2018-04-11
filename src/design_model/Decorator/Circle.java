package design_model.Decorator;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/4/11
 * Time:21:26
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}
