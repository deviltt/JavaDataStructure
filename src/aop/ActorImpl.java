package aop;

public class ActorImpl implements Actor {
    @Override
    public void dance() {
        System.out.println("周杰伦跳舞");
    }

    @Override
    public void sing() {
        System.out.println("周杰伦唱歌");
    }
}
