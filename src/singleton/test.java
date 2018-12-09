package singleton;

public class test {
    public static void main(String[] args){
//        Singleton1 singleton1 = Singleton1.getInstance();
//        Singleton1 singleton2 = Singleton1.getInstance();
//
//        Singleton2 singleton21 = Singleton2.getInstance();
//        Singleton2 singleton22 = Singleton2.getInstance();
//        System.out.println(singleton1 == singleton2);
//        System.out.println(singleton21 == singleton22);
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton4 singleton41 = Singleton4.getInstance();
        System.out.println(singleton4 == singleton41);
    }
}
