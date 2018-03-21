package sometest;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/21
 * Time:20:54
 */
public class People {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public People() {
    }

    public People(String name, String age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
