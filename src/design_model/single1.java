package design_model;



public class single1 {
    private static single1 ourInstance = null;

    public static single1 getInstance() {
        if (ourInstance == null){
            synchronized (single1.class){
                if (ourInstance == null){
                    ourInstance = new single1();
                }
            }
        }
        return ourInstance;
    }

    private single1() {
    }
}
