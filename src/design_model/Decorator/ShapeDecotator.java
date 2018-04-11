package design_model.Decorator;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/4/11
 * Time:21:30
 */
public class ShapeDecotator implements Shape{
    private Shape shape;

    public  ShapeDecotator(Shape shape){
        this.shape = shape;
    }
    @Override
    public void draw() {
        System.out.println("装饰增强");
        shape.draw();
    }
}
