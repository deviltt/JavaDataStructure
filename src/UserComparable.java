import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserComparable implements Comparable<UserComparable>{
    private String name;
    private int age;

    //有参构造方法
    private UserComparable(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(UserComparable o) {
        //如果名字相同，则根据年龄排序，及名字优先再年龄
        if(this.name.compareTo(o.name) == 0){
            return Integer.compare(this.age, o.age);
        }
        else if(this.name.compareTo(o.name) > 0)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString(){
        return "UserComparable{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                '}';
    }

    public static void main(String[] args){
        List<UserComparable> list = new ArrayList<>();
        list.add(new UserComparable("gol", 21));
        list.add(new UserComparable("gol", 19));
        list.add(new UserComparable("xiao", 21));
        list.add(new UserComparable("long", 21));
        System.out.println("排序前：" + list);
        Collections.sort(list);
        System.out.println("排序后：" + list);
    }
}
