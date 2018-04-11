package design_model.Decorator;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/4/11
 * Time:21:40
 */
public class Test {
    public static void main(String[] args) {
        Shape shape = new Circle();
        ShapeDecotator shapeDecotator = new ShapeDecotator(shape);
        shapeDecotator.draw();
    }
}
