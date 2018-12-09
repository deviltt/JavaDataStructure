package singleton;

/**
 * 饿汉模式：声明的时候就进行实例化
 */
public class Singleton1 {
    //构造方法私有化
    private Singleton1(){}

    //创建的时候进行实例化
    private static Singleton1 singleton1 = new Singleton1();


    public static Singleton1 getInstance(){
        return singleton1;
    }
}
