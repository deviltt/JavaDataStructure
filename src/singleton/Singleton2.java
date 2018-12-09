package singleton;

/**
 * 懒汉模式：声明类对象的时候不进行实例化，当类对象已经存在则直接返回，否则先实例化在进行返回
 */
public class Singleton2 {
    private Singleton2(){}

    private static Singleton2 singleton2;

    public static Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
            return singleton2;
        }
        return singleton2;
    }
}
