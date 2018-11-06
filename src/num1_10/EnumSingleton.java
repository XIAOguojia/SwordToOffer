package num1_10;

/**
 * 枚举单例
 */
public enum EnumSingleton {
    /**
     * 单例
     */
    INSTANCE(1);


    EnumSingleton(int i) {

    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public void OtherMethod(){
        //do something
        System.out.println("OtherMethod");
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE);
    }
}
