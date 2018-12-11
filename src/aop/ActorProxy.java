package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActorProxy implements InvocationHandler {
    //初始化目标对象，测试类中会传入实现Actor接口的目标类对象
    private Actor actor;
    public ActorProxy(Actor actor){
        this.actor = actor;
    }

    public Object createProxy(){
        //1.获取目标类对象的类加载器；2.获取目标类对象的接口；3.定义这个方法的代理类
        return Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), this);
    }

    //method是目标类对象中的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("dance".equals(method.getName())){
            System.out.println("化妆师给他穿跳舞的衣服...");
            Object object = method.invoke(actor, args);
            System.out.println("跳舞经纪人给他开新闻发布会...");
            return object;
        }
        else {
            System.out.println("化妆师给他穿唱歌的衣服...");
            Object object = method.invoke(actor, args);
            System.out.println("唱歌经纪人给他开新闻发布会...");
            return object;
        }
    }
}
