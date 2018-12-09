package singleton;

/**
 * 懒汉模式：在调用getInstance();方法的时候进行线程同步
 * 但这种方法在每一次想要获取实例对象时都要进行一次线程的同步，大大降低了效率，不建议使用
 */
public class Singleton3 {
    private Singleton3(){}

    private static Singleton3 singleton3;

    public static synchronized Singleton3 getInstance(){
        if(singleton3 == null){
            singleton3 = new Singleton3();
            return singleton3;
        }
        return singleton3;
    }
}
