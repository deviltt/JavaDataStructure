package initialization;

/**
 * 创建静态块
 * 1.首次访问静态块数据成员时调用
 * 2.首次生成这个类对象时
 */
class Cup{
    Cup(int maker){
        System.out.println("Cup(" + maker + ")");
    }
    void f(int maker){
        System.out.println("f(" + maker + ")");
    }
}
class Cups{
//    static Cup cup1;
//    static Cup cup2;
//    static {
//        cup1 = new Cup(1);
//        cup2 = new Cup(2);
//    }
    static Cup cup1 = new Cup(1);
    static Cup cup2 = new Cup(2);   //这种形式声明方式在访问静态数据cup1时，cup2同样也被初始化了，不一定封装在静态块中
    Cups(){
        System.out.println("Cups()");
    }
}
public class ExplicitStatic {
    public static void main(String[] args){
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }
//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();
}
