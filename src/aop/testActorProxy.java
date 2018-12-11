package aop;

public class testActorProxy {
    public static void main(String[] args){
        Actor actor = new ActorImpl();
        Actor proxy = (Actor) new ActorProxy(actor).createProxy();
        proxy.dance();
        proxy.sing();
    }
}
